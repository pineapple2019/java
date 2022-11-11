package com.m.demo03;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier cb = new CyclicBarrier(5,new MainTask()); 
		new Thread(new ChildTask(cb)).start();
		new Thread(new ChildTask(cb)).start();
		new Thread(new ChildTask(cb)).start();
		new Thread(new ChildTask(cb)).start();
		new Thread(new ChildTask(cb)).start();
	}

}
class MainTask implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("���߳�"+Thread.currentThread().getName()+"�������");
	}
	
}
class ChildTask implements Runnable{
	private CyclicBarrier cb;
	public ChildTask(CyclicBarrier cb) {
		this.cb = cb;
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+"�������");
			this.cb.await();//֪ͨ�ϰ�������ǰ���߳�ִ�����
			System.out.println(Thread.currentThread().getName()+"�����������");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}