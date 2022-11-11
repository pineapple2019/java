package 多线程.wkcto.intrinsiclock;

/**
 * * synchronized 同步代码块
 * * this 锁对象
 * mm方法用锁，锁起来，变成同步代码块，这样的好处是？
 * 并发变为串行，一次只能由一个线程访问，
 * 保证原子性、可见性、有序性
 */

public class Test01 {
    public static void main(String[] args) {
        final Test01 obj = new Test01();
        //创建两个线程。调用mm方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();   //使用的锁对象this就是obj对象
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();   //使用的锁对象this也是obj对象
            }
        }).start();
    }

//    public void mm(){
//        for (int i=1;i<=100;i++){
//            System.out.println(Thread.currentThread().getName()+"-->"+i);
//        }
//    }

    /**
     *
     * 使用锁之后，就会保证线程的原子性、可见性、有序性
     * 不会在其中一个线程执行过程中，其他线程乱入！
     * 实现了并发的串行访问！
     *
     */
        public void mm(){
            synchronized (this){
            for (int i=1;i<=100;i++){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }

}
