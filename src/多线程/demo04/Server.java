package com.m.demo04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws Exception {
		//1.创建服务
		//2.port:端口（同一个系统当中唯一）
		ServerSocket server = new ServerSocket(9999);
		System.out.println("启动服务");
		while(true) {//服务器要不断的接收请求
			Socket socket = server.accept();//监听通讯请求
			//分发请求到线程当中
			new Thread(new SocketThread(socket)).start();
		}
	}
}

class SocketThread implements Runnable{
	private Socket socket;
	private Scanner scanner = new Scanner(System.in);
	public SocketThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			//接收请求
			BufferedReader r = new BufferedReader(
					new InputStreamReader(
							this.socket.getInputStream()));
			while(true) {
				String line = r.readLine();
				if(line == null) {
					break;
				}else {
					System.out.println("客户端："+line);
				}
			}
			this.socket.shutdownInput();//单方面关闭输入流
			
			//向客户端响应
			BufferedWriter w = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			System.out.print("服务器：");
			String responseMessgae = scanner.nextLine();
			w.write(responseMessgae);
			w.flush();
			this.socket.shutdownOutput();//单方面关闭输出流
			
			w.close();//一旦调用close，会同时关闭socket
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}




