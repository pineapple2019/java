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
//    //获得条件变量
//    Condition c = null;
//    public void test() {
//        c = lock.newCondition();//条件变量可以有多个
//        try {
//            lock.lock();
//            System.out.println(Thread.currentThread().getName()+"获得锁");
//            c.await();//等待
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