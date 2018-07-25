package socketNio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



/**
 * Title:SocketNioServer.java <br>
 * Description:nio连接 <br>
 * Company:www.ylms.com <br>
 * @author XieXiongShi
 * @date 2018年7月5日 下午3:56:42
 * @version V 1.0 
 */
public class SocketNioServer {

	// 处理请求的线程池
	private static final ThreadPoolExecutor threadpoolexecutor = new ThreadPoolExecutor(
			25, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	private static ServerSocketChannel serverSocketChannel;
	private static Selector selector;
    private int port = 8080;
    public SocketNioServer(int port){
    	this.port=port;
    }
	public  void start() throws Exception{
		// 打开一个通讯通道
		serverSocketChannel = ServerSocketChannel.open();
		// 设定非阻塞模式
		serverSocketChannel.configureBlocking(false);
		// 绑定一个端口
		serverSocketChannel.bind(new InetSocketAddress(this.port));
		System.out.println("端口监听开启:" + this.port);
		// 打开选择器
		selector = Selector.open();
		// 在端口上添加一个选择器，选择条件是新的连接(OP_ACCEPT)
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (true) {

			// 开始查询
			// 如果没有查询结果,等待一秒，如果还没有结果，继续执行下面的代码
			selector.select(1000);
			// 查询所有
			Set<SelectionKey> result = selector.selectedKeys();
			Iterator<SelectionKey> iterator = result.iterator();
			while (iterator.hasNext()) {
				// 得到的结果(有两种情况:新的连接(无数据)和有数据的连接)
				SelectionKey value = iterator.next();
				// 当是新的连接时
				if (value.isAcceptable()) {
					// 获取新的连接
					SocketChannel socketChannel = serverSocketChannel.accept();
					// 设置非阻塞模式
					socketChannel.configureBlocking(false);
					// 告诉选择器有数据时才处理
					socketChannel.register(selector, SelectionKey.OP_READ);

				} else if (value.isReadable()) {// 如果是有数据

					// 获取有数据的通道
					final SocketChannel socketChannel = (SocketChannel) value
							.channel();
					// 告诉选择器selector取消对有数据的查询
					value.cancel();
					socketChannel.configureBlocking(false);
					// 交给线程池处理
					threadpoolexecutor.execute(new Runnable() {

						@Override
						public void run() {

							try {

								// 开始响应客户端
								// 申请一个读写空间
								ByteBuffer request = ByteBuffer.allocate(1024);
								// 读取数据
								socketChannel.read(request);
								request.flip();
								System.out.println("当前线程数:"
										+ threadpoolexecutor.getActiveCount()
										+ ",收到数据" + new String(request.array()).trim());
								socketChannel.write(request);
							} catch (IOException e) {
								e.printStackTrace();
							} finally {
								// 继续交给selector来处理
								try {
									socketChannel.register(selector,
											SelectionKey.OP_READ);
								} catch (ClosedChannelException e2) {
									e2.printStackTrace();
								}
							}

						}
					});

				}

			}
			// 清空结果集，防止重复处理
			result.clear();
		}
	}
	public static void main(String[] args) throws Exception {
		new SocketNioServer(8080).start();
	}
}
