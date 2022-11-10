package com.wkcto.intrinsiclock;

/**
 * synchronized 同步代码块
 * 使用一个常量对象作为锁对象，可以实现同步效果
 */
public class Test03 {
    public static void main(String[] args)
    {
        //创建两个线程,分别调用 mm()方法
        //先创建 Test01 对象,通过对象名调用 mm()方
       final Test03 obj = new Test03();
       final Test03 obj2 = new Test03();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();   //使用锁对象this是obj对象
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj2.mm();  //使用锁对象this是obj2对象
            }
        }).start();
    }

     /**
     * 定义一个常量
     */
      public static final  Object OBJ = new Object();

    /**
     * 我自己试了一下，使用字符串常量也可以
     */
//        public static final String OBJ = new String();
        public void mm(){
        synchronized (OBJ){
            for (int i=1;i<=100;i++){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }
}





