package socketBio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @projectName:socketBIODemo   
 * @ClassName:SocketBioServer   
 * @Description:服务端  
 * @author:Xxs  
 * @date:2018年7月24日
 * 修改人:Administrator   
 * 修改时间:2018年7月24日 下午11:50:19   
 * 修改备注:   
 * @version   
 */
public class SocketBioServer {

	// 一个请求过来，会新开一个线程进行处理
	// 处理请求的线程池
	public static final ThreadPoolExecutor threadpoolexecutor = new ThreadPoolExecutor(
			25, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		try {
			// 端口监听
			serverSocket = new ServerSocket(8082);
			System.out.println("当前线程" + Thread.currentThread().getName()
					+ "启动" + 8082+"端口");
			while (true) {

				// 阻塞的获取连接，没有新的连接会一直停在这里
				Socket socket = serverSocket.accept();
				// 用线程池来处理
				threadpoolexecutor.execute(new SocketBioServer().new SocketProcessor(socket));
				System.out.println("有新的连接啦，当前线程数:"
						+ threadpoolexecutor.getActiveCount());
			}

		} catch (Exception e) {
            e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				serverSocket.close();
			}
		}

	}
	// 处理socket
	class SocketProcessor implements Runnable {

		Socket socket;

		public SocketProcessor(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			// 给客户端返回简单的字符串
			try {
				// 创建一个字节数组
			byte[] requsetbody = new byte[1024];	
				socket.setSoTimeout(1000000);
				// 获取客户端的流并解析
				// 阻塞状态，如果没数据就会一直等在这里
				socket.getInputStream().read(requsetbody);
				// 转换成字符串
				String request = new String(requsetbody);
				System.out.println("当前线程池数量"
						+ threadpoolexecutor.getActiveCount() + "客户端的请求是:"
						+ request);
				// 响应客户端

				socket.getOutputStream().write(
						("服务端收到了信息:"+request+"接收时间" + System
								.currentTimeMillis()).getBytes());
				socket.getOutputStream().flush();// 刷新
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 处理完一个请求后，继续丢给线程池，继续阻塞一直等到有数据
				SocketBioServer.threadpoolexecutor
						.execute(new SocketProcessor(socket));
			}
		}

	}

}
