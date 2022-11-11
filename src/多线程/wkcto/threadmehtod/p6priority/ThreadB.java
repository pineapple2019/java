package 多线程.wkcto.threadmehtod.p6priority;

public class ThreadB extends Thread {
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        long sum = 0 ;
        for(long i = 0 ; i<= 10000000000L; i++){
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("thread B : " + (end - begin));
    }
}
