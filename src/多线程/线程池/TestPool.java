package 多线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
    //1,创建服务,创建线程池，控制要创建几个线程
    ExecutorService pool =  Executors.newFixedThreadPool(5);
    //执行
//    pool.execute(new void MyThread1());
//    pool.execute(new void MyThread1());
//
//    //2，关闭链接，关闭线程池
//    pool.shutdown();
}


class MyThread1 implements Runnable{
    public MyThread1(){}
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"使用线程池进行创建");
    }
}

