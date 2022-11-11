package com.m.demo01;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Queue<T> {
	private LinkedList<T> list = new LinkedList<T>();
	private static final Integer DEFAULT_MAX_SIZE = 10;
	private Integer maxSize = 0;
	private Lock lock = new ReentrantLock();
	private Condition c = null;
	public Queue() {
		this(DEFAULT_MAX_SIZE);
	}
	public Queue(Integer maxSize) {
		c = lock.newCondition();
		this.maxSize = maxSize;
	}
	/**
	 * 往队列当中加
	 */
	public void add(T t) {
		lock.lock();//持锁
		//当list达到最大值就不能再加了，要等待
		while(list.size() == maxSize) {//队列满了
			try {
				System.out.println("队列满了");
				this.c.await();//等到队列有线程消费了一个以后，唤醒该等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//没有达到最大值往里面加内容
		list.addFirst(t);//往最前面加
		//唤醒队列为空的情况下处于等待的线程
		this.c.signalAll();
		lock.unlock();//释放锁
	}
	/**
	 * 从队列当中取
	 */
	public T get() {
		lock.lock();//持锁
		//当list里的元素为0的时候，不能再取要等待
		while(list.size() == 0) {//队列空了
			try {
				System.out.println("队列空了");
				this.c.await();//这个等待需要等到再有元素加入后唤醒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Object obj = list.getLast();//从最后面取
		//从队列当中移除
		list.removeLast();
		//唤醒队列满了以后处于等待的线程
		this.c.signalAll();
		lock.unlock();//释放锁
		return (T)obj;
	}
}






