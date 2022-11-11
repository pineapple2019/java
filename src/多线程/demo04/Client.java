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
		//1.����socket���������������
		while(true) {
			Socket socket = new Socket("localhost", 9999);
			//�ͻ��˷�������
//			ObjectOutputStream in = new ObjectOutputStream(socket.getOutputStream());
			BufferedWriter w = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			System.out.print("�ͻ��ˣ�");
			String requestMessage = scanner.nextLine();
			w.write(requestMessage);
			w.flush();//��ջ�����
			socket.shutdownOutput();//������ر������
			
			//���շ�������Ӧ
			BufferedReader r = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			while(true) {
				String line = r.readLine();
				if(line == null) {
					break;
				}else {
					System.out.println("��������"+line);
				}
			}
			socket.shutdownInput();//������ر�����
			
			w.close();
			r.close();
		}
	}
}
