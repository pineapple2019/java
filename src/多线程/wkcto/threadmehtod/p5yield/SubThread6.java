package 多线程.wkcto.threadmehtod.p5yield;

/**
 * 线程让步
 * @author pineapple
 */
public class SubThread6 extends Thread {
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        long sum = 0;
        for(int i = 1; i <= 1000000; i++){
            sum += i;
            Thread.yield(); //线程让步, 放弃 CPU 执行权
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+",用时: " + (end - begin));
    }
}

