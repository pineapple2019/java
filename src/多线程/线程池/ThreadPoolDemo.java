package 多线程.线程池;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建线程池对象
        ExecutorService service = Executors.newFixedThreadPool(2);
        //创建Callable对象
        MyCallable c = new MyCallable();
        //从线程池中获取线程对象，然后调用MyRunnable中的run()
        service.submit(c);
        service.submit(c);
        //关闭线程池
        service.shutdown();
    }
}
//稍微的修改
class MyCallable implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("我要一个教练：call");
        Thread.sleep(2000);
        System.out.println("教练来了："+ Thread.currentThread().getName());
        System.out.println("叫我游泳，交完后，教练回到了游泳池");
        return null;
    }
}
