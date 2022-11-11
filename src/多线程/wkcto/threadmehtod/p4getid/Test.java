package 多线程.wkcto.threadmehtod.p4getid;

/**
 * @author pineapple
 */
public class Test {
    public static void main(String[] args) {
        System.out.println( Thread.currentThread().getName() + " , id = " + Thread.currentThread().getId());
        //子线程的 id
        for(int i = 1; i <= 1000; i++){
            new SubThread5().start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


