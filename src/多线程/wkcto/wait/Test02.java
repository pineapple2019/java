package 多线程.wkcto.wait;

public class Test02 {
    public static void main(String[] args) {
            try {
                String text = "wkcto";
                String another = "hello";

                System.out.println("同步前的代码块");
                synchronized (text){
                    System.out.println("同步代码块开始。。。");
//                    text.wait();
                    another.wait(); //如果不是锁对象调用wait，会报异常
                    //调用wait（）方法后，当前线程就会等待，释放锁对象，当前线程需要被唤醒，如果没有被唤醒，那么就会一直等待
                    System.out.println("wait后面的代码。。。。");
                }
                System.out.println("wait后面的代码");
            } catch (InterruptedException e) {
                //异常了，这句话居然没有打印！
                System.out.println("异常！");
                e.printStackTrace();
            }
        System.out.println("main后面的其他代码。。。");
    }
}
