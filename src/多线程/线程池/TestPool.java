//package 多线程.线程池;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//
//public class TestPool {
//    //1,创建服务,创建线程池
//    ExecutorService service =  Executors.newFixedThreadPool(5);
//    //执行
//    service.execute(new MyThread());
//    service.execute(new MyThread());
//    service.execute(new MyThread());
//    service.execute(new MyThread());
//    service.execute(new MyThread());
//    //2，关闭链接
//    service.shutdown();
//}
//
//class MyThread implements Runnable{
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName());
//    }
//}
//
