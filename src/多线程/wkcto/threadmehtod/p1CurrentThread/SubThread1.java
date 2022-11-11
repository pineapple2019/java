package 多线程.wkcto.threadmehtod.p1CurrentThread;

/**
 * 定义线程类
 *  分别在构造方法中和 run方法中打印当前线程
 * @author pineapple
 */
public class SubThread1 extends Thread {
        public SubThread1(){
            System.out.println("构造方法打印当前线程名称: " +Thread.currentThread().getName());
        }

        @Override
        public void run() {
            System.out.println("run方法打印当前线程名称 :" + Thread.currentThread().getName());
        }

 }

