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
	 * �����е��м�
	 */
	public void add(T t) {
		lock.lock();//����
		//��list�ﵽ���ֵ�Ͳ����ټ��ˣ�Ҫ�ȴ�
		while(list.size() == maxSize) {//��������
			try {
				System.out.println("��������");
				this.c.await();//�ȵ��������߳�������һ���Ժ󣬻��Ѹõȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//û�дﵽ���ֵ�����������
		list.addFirst(t);//����ǰ���
		//���Ѷ���Ϊ�յ�����´��ڵȴ����߳�
		this.c.signalAll();
		lock.unlock();//�ͷ���
	}
	/**
	 * �Ӷ��е���ȡ
	 */
	public T get() {
		lock.lock();//����
		//��list���Ԫ��Ϊ0��ʱ�򣬲�����ȡҪ�ȴ�
		while(list.size() == 0) {//���п���
			try {
				System.out.println("���п���");
				this.c.await();//����ȴ���Ҫ�ȵ�����Ԫ�ؼ������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Object obj = list.getLast();//�������ȡ
		//�Ӷ��е����Ƴ�
		list.removeLast();
		//���Ѷ��������Ժ��ڵȴ����߳�
		this.c.signalAll();
		lock.unlock();//�ͷ���
		return (T)obj;
	}
}






