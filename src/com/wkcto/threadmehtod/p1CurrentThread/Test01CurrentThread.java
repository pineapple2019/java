package com.wkcto.threadmehtod.p1CurrentThread;

/**
 * 测试当前线程
 * @author pineapple
 */
public class Test01CurrentThread {
    public static void main(String[] args) {

        System.out.println("main 方法中打印当前线程 :" + Thread.currentThread().getName());

        //创建子线程, 调用 SubThread1()构造方法, 在 main 线程中调用构造方法,所以构造方法中的当前线程就是 main 线程
        SubThread1 t1 = new SubThread1();
        //t1.start(); //启动子线程,子线程会调用 run()方法,所以 run()方法中 的当前线程就是 Thread-0子线程
        t1.run(); //在 main 方法中直接调用 run()方法,没有开启新的线程,所以在 run 方法中的当前线程就是 main 线程
        //返回线程名称
        System.out.println( t1.getName());
    }
}



