package com.wkcto.intrinsiclock;

/**
 * 运行的结果是，可以实现同步
 * 我突然悟了，悟了多线程的作用
 * 我们使用多线程，做这些事情，为的就是给客户一种单线程的体验
 * 就是，实现单线程的效果，其实内部是多线程的操作
 *
 * 此时，我可以总结一下多线程的优点：
 * 1，多线程可以节省时间，提高效率
 * 2，多线程用的好，给客户一对一的体验，其实背后是一对多
 *
 * 本次代码的总结：不管同步代码块是在实例方法中还是静态方法中，跟其所在的位置没有关系，
 * 只要是同一个锁对象，就可以实现同步，这个同步我理解的就是，实现单线程的效果
 *

 *
 *
 * * synchronized 同步代码块
 * * 使用一个常量对象作为锁对象,不同方法中的同步代码块也可以同步
 *
 */

public class Test04 {
    public static void main(String[] args) {
        final Test04 obj = new Test04();
        final Test04 obj2 = new Test04();
        //以下3个方法可以实现同步
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();   //使用锁对象是OBJ常量
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj2.mm();  //使用锁对象是OBJ常量
            }
        }).start();
        //第三个线程调用静态方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                sm();  //使用锁对象是OBJ常量
            }
        }).start();
}

    public static final  Object OBJ = new Object(); //定义一个常量

    public void mm(){
        synchronized (OBJ){
            for (int i=1;i<=100;i++){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }

    /**
     *     定义sm方法：
     *     这是一个静态方法，区别于上面的实例方法
     *     锁对象一样，都是常量OBJ
     *     二者的功能一样的
     */

    public static void sm(){
        synchronized (OBJ){
            for (int i=1;i<=100;i++){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }
}


