//package com.m.demo01;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class Test {
//
//    public static void main(String[] args) {
//        A a = new A();
//        Thread t = new Thread(new MyThread(a));
//        ExecutorService pool = Executors.newFixedThreadPool(2);
//        pool.execute(t);
//        pool.execute(t);
//        pool.shutdown();
//    }
//
//}
//class A{
//    Lock lock = new ReentrantLock();
//    //�����������
//    Condition c = null;
//    public void test() {
//        c = lock.newCondition();//�������������ж��
//        try {
//            lock.lock();
//            System.out.println(Thread.currentThread().getName()+"�����");
//            c.await();//�ȴ�
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//class MyThread implements Runnable{
//    private final A a;
//    public MyThread(final A a) {
//        this.a = a;
//    }
//    @Override
//    public void run() {
//        // TODO Auto-generated method stub
//        this.a.test();
//    }
//
//}