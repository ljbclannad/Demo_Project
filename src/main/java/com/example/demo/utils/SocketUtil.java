package com.example.demo.utils;

import lombok.extern.log4j.Log4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Log4j
public class SocketUtil {
 
	public static String Socket(String message,String host,int port) throws Exception {
	    // 要连接的服务端IP地址和端口
//	    String host = "192.168.3.58";
//	    int port = 8903;
	    // 与服务端建立连接
		log.info("message:"+message);
	    Socket socket = new Socket(host, port);
	    socket.setSoTimeout(30000);
	    // 建立连接后获得输出流
	    OutputStream outputStream = socket.getOutputStream();
	    log.info("outputStream:"+outputStream);
	    socket.getOutputStream().write(message.getBytes("UTF-8"));
	    
	    //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
	    socket.shutdownOutput();
	    
	    InputStream inputStream = socket.getInputStream();
	    log.info("inputStream:"+inputStream);
	    byte[] bytes = new byte[1024];
	    int len;
	    StringBuilder sb = new StringBuilder();
	    while ((len = inputStream.read(bytes)) != -1) {
	      //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
	      sb.append(new String(bytes, 0, len,"UTF-8"));
	    }
	    log.info("socket连接接收到的返回参数%{}"+sb);
	    
	    inputStream.close();
	    outputStream.close();
	    socket.close();
		return sb.toString();
	  }

	
	
}

 


