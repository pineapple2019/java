package 多线程.wkcto.createthread.p1;

/**
 * 1)定义类，继承Thread
 * @author pineapple
 */
public class MyThread extends Thread{
    /**
     *  2) 重写 Thread 父类中的 run()
     *  run()方法体中的代码就是子线程要执行的任务
     */

    @Override
    public void run() {
        System.out.println("这是子线程打印的内容");
    }
}




