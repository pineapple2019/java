package com.wkcto.threadmehtod.p3sleep;

/**
 * @author pineapple
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        SubThread4 t4 = new SubThread4();
        System.out.println("main__begin = " + System.currentTimeMillis());
        //开启新的线程
         t4.start();
        //在 main 线程中调用实例方法 run(),没有开启新的线程
        //t4.run();
        System.out.println("main__end = " + System.currentTimeMillis());
    }
}





