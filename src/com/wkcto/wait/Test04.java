package com.wkcto.wait;

import java.util.ArrayList;
import java.util.List;

/**
 * notify()不会立即释放锁对象
 */

public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        //定义一个List集合存储String数据
        final List<String> list = new ArrayList<>();
        //定义第一个线程，当list集合中的元素数量不等于5时，线程等待
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list){
                    if(list.size()!=5){
                        System.out.println("线程1开始等待："+System.currentTimeMillis());
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程1被唤醒："+System.currentTimeMillis());
                    }
                }
            }
        });

        //定义第二个线程，向list集合中添加元素
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list){
                    for (int i=0;i<10;i++){
                        list.add("data--"+i);
                        System.out.println("线程2添加了第"+(i+1)+"个数据");

                        if (list.size() == 5){
                            list.notify();
                            //唤醒线程，不会立即释放锁对象，
                            //需要等待当前同步代码块都执行完毕之后才能释放锁对象
                            System.out.println("线程2发出唤醒通知");
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        //为了确保t2在t1之后开启，即让t1线程先睡眠
        Thread.sleep(5000);
        t2.start();
    }
}
