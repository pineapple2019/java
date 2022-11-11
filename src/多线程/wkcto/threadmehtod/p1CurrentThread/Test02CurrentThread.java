package 多线程.wkcto.threadmehtod.p1CurrentThread;

/**
 * @author pineapple
 */
public class Test02CurrentThread {
    public static void main(String[] args) throws InterruptedException {
        //创建子线程对象
        SubThread2 t2 = new SubThread2();
        //设置线程的名称
        t2.setName("t2");
        t2.start();
        //main 线程睡眠 500 毫秒
        Thread.sleep(500);

        /**
         * Thread(Runnable)构造方法形参是Runnable接口，调用时，传递的实参是接口的实现类对象
         * 不会调用构造方法，是因为父类Thread不会去调用子类SubThread2的构造方法
         */

        Thread t3 = new Thread(t2);
        //开启t3线程，调用run方法，我还是不明白，为什么第一个是t3，第二个是t2啊
        t3.start();
    }
}


