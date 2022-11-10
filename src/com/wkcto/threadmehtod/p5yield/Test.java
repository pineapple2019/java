package com.wkcto.threadmehtod.p5yield;

public class Test {
    public static void main(String[] args) {
        //开启子线程,计算累加和
        SubThread6 t6 = new SubThread6();
        t6.start();
        //在 main 线程中计算累加和
        long begin = System.currentTimeMillis();
        long sum = 0;
        for(int i = 1; i <= 1000000; i++){
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("main 方法 , 用时: " + (end - begin));
    }
}
