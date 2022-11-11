package 多线程.wkcto.threadmehtod.p3sleep;

/**
 * @author pineapple
 */
public class SubThread4 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run, thread name=" + Thread.currentThread().getName()+" ,begin= " + System.currentTimeMillis());
            //当前线程睡眠 2000 毫秒
            Thread.sleep(2000);
            System.out.println("run, thread name=" + Thread.currentThread().getName() + " ,end= " + System.currentTimeMillis());
            } catch (InterruptedException e) {
            /**在子线程的 run 方法中, 如果有受检异常(编译时异常)需要处理,只有选择捕获处理,不能抛出处理
                因为在runnable中没有抛异常，所以，重写后的run方法也不能抛异常
             */
            e.printStackTrace();
        }
    }
}




