package 多线程.wkcto.createthread.p1;

/**
 * @author pineapple
 */
public class Test {
    public static void main(String[] args) {

        System.out.println("JVM 启动 main 线程,main 线程执行 main 方法");
        //3)创建子线程对象
        Thread thread = new MyThread();

        //4)启动线程
        thread.start();
        /**
         * 调用线程的start()方法来启动线程, 启动线程的实质就是请求JVM运行相应的线程,这个线程具体在什么时候运行由线程调度器(Scheduler)决定
 *         注意:start()方法调用结束并不意味着子线程开始运行,
         *         新开启的线程会执行run()方法
 *             如果开启了多个线程,start()调用的顺序并不一定就是线程启动的顺序
 *             多线程运行结果与代码执行顺序或调用顺序无关(重要，线程安全问题：有序性问题)
         */
        System.out.println("main 线程后面其他的代码...");
    }
}


