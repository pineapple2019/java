package 多线程.wkcto.threadmehtod.p4getid;

/**
 * @author pineapple
 */
public class SubThread5 extends Thread {
    @Override
    public void run() {
        System.out.println("thread name = " + Thread.currentThread().getName() + ", id == " + this.getId() );
    }
}

