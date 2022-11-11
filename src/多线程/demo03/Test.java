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
		System.out.println("主线程"+Thread.currentThread().getName()+"任务完成");
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
			System.out.println(Thread.currentThread().getName()+"任务完成");
			this.cb.await();//通知障碍器，当前子线程执行完毕
			System.out.println(Thread.currentThread().getName()+"后续任务完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}