package com.wkcto.intrinsiclock;

/**
 * * synchronized 同步实例方法
 * * 把整个方法体作为同步代码块
 * * 默认的锁对象是 this 对象
 *
 *  * 将整个方法体作为同步代码块
 *  * 咱就是说：只要是同一个锁对象，就可以实现同步
 *  * 因为他们使用了同一把锁
 */

public class Test05 {
    public static void main(String[] args) {
        final Test05 obj = new Test05();

        //一个线程调用mm方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                //使用锁对象this是obj对象
                obj.mm();
            }
        }).start();

        //一个线程调用mm2方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm2();  //使用锁对象this是obj对象
                /**
                 * 我突然对同步这个词悟了，咱就是说
                 * 我刚刚看了一下课件笔记，发现，我现在正在学的内容叫做
                 * 线程同步
                 * 线程同步机制的实现
                 * 《线程同步机制是一套用于协调线程之间数据访问的机制，该机制可以保障线程安全》
                 * 我刚刚想到的也是这个意思
                 * 找个通俗的理解，就是我之前一直苦苦困惑的多台电脑之间的数据同步，以及前几天想到的
                 * 微信pc和手机内容同步，就是这个意思
                 * 比如说手机上发消息，电脑上发消息，这两个肯定要有一个先来后到的顺序，线程同步就是为了保证这个顺序的！
                 * 我也一直苦于这个微信内容不同步，或者不同电脑办公，笔记之类的不能同步！
                 * 现在我学到的方法：就是这个锁机制，synchronized（具有排他性，就是一个线程占用锁的时候，其他线程无法获得锁）
                 * 锁也是令牌，如果没有获得锁，就没有被cpu执行的权利，不能被cpu宠幸！
                 * 但是如果你不使用锁了，那也不能一直占着锁不放，就是用完就得释放，不能占着茅坑不拉屎！
                 */
//                new Test05().mm2();                 // 这样就不能实现同步了，因为使用的锁对象不是同一个。

            }
        }).start();

}


    public void mm(){
        //经常使用this当前对象作为锁对象
        synchronized (this){
            for (int i=1;i<=100;i++){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }

    /**
     * 使用synchronized修饰实例方法，同步实例方法，默认this作为锁对象
     */
    public synchronized void mm2(){
            for (int i=1;i<=100;i++){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }


}


