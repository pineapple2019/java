package com.m.demo02;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
	
	public static void main(String[] args) {
		//�������ֵ�ǰ�ȫ��
		AtomicInteger inter = new AtomicInteger(100);
		System.out.println(inter.getAndSet(120));
		System.out.println(inter.get());
		//����ȫ
//		int i = 1;
//		inter.set(++i);
//		int j = inter.get();
//		inter.set(j + i);
		
		int i = 1;
		inter.set(i);//���û����
		final int J = 100;
		inter.set(J);
	}

}
