package 多线程.wkcto.threadmehtod.p2IsAlive;

/**
 * @author pineapple
 */
public class SubThread3 extends Thread {
    @Override
    public void run() {
        //运行状态,true
        System.out.println("run 方法, isAlive = " + this.isAlive());
    }
}


