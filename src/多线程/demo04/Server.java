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
		//1.��������
		//2.port:�˿ڣ�ͬһ��ϵͳ����Ψһ��
		ServerSocket server = new ServerSocket(9999);
		System.out.println("��������");
		while(true) {//������Ҫ���ϵĽ�������
			Socket socket = server.accept();//����ͨѶ����
			//�ַ������̵߳���
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
			//��������
			BufferedReader r = new BufferedReader(
					new InputStreamReader(
							this.socket.getInputStream()));
			while(true) {
				String line = r.readLine();
				if(line == null) {
					break;
				}else {
					System.out.println("�ͻ��ˣ�"+line);
				}
			}
			this.socket.shutdownInput();//������ر�������
			
			//��ͻ�����Ӧ
			BufferedWriter w = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			System.out.print("��������");
			String responseMessgae = scanner.nextLine();
			w.write(responseMessgae);
			w.flush();
			this.socket.shutdownOutput();//������ر������
			
			w.close();//һ������close����ͬʱ�ر�socket
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}




