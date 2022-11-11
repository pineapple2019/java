package com.m.demo04;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InetAddress address = InetAddress.getByName("localhost");
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());
	}

}
