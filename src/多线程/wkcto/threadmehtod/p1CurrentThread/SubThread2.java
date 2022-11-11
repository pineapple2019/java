package 多线程.wkcto.threadmehtod.p1CurrentThread;

/**
 * * 当前线程的复杂案例
 * @author pineapple
 */
public class SubThread2 extends Thread {
    public SubThread2(){
        System.out.println("构造方法中 ,Thread.currentThread().getName() : " + Thread.currentThread().getName() );
        System.out.println("构造方法,this.getName() : " + this.getName());
    }
    @Override
    public void run() {
        System.out.println("run 方法中 ,Thread.currentThread().getName() : " + Thread.currentThread().getName());
        System.out.println("run 方法,this.getName() : " + this.getName());
    }
}




