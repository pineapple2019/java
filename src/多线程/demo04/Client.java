package com.m.demo04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		//1.建立socket向服务器发起请求
		while(true) {
			Socket socket = new Socket("localhost", 9999);
			//客户端发起请求
//			ObjectOutputStream in = new ObjectOutputStream(socket.getOutputStream());
			BufferedWriter w = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			System.out.print("客户端：");
			String requestMessage = scanner.nextLine();
			w.write(requestMessage);
			w.flush();//清空缓冲区
			socket.shutdownOutput();//单方面关闭输出流
			
			//接收服务器响应
			BufferedReader r = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			while(true) {
				String line = r.readLine();
				if(line == null) {
					break;
				}else {
					System.out.println("服务器："+line);
				}
			}
			socket.shutdownInput();//单方面关闭输入
			
			w.close();
			r.close();
		}
	}
}
