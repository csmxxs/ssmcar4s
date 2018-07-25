package socketNio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 非阻塞式流(适用于互联网的海量连接)
 * 模拟一个客户端
 * */
public class Client{
    public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket= new Socket("localhost",8080);
	     System.out.println("和8080端口建立新的连接，等待输入内容，客户端端口号:"+socket.getLocalPort());
         //获取控制台输入的内容
	     BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
         String request;
         while(true){
        	 request = reader.readLine();
        	 //发送请求
        	 socket.getOutputStream().write(request.getBytes());
        	 //接收响应
        	 byte[] response= new byte[64];
        	 socket.getInputStream().read(response);
        	 System.out.println("收到服务器的响应:"+new String(response).trim());
         }
    }

}
