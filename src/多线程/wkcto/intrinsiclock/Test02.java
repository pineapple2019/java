package 多线程.wkcto.intrinsiclock;


/**
 * * synchronized 同步代码块
 * * 如果线程的锁不同, 不能实现同步
 * * 想要同步必须使用同一个锁对象
 */
public class Test02 {
    public static void main(String[] args) {
        final Test02 obj = new Test02();
        final Test02 obj2 = new Test02();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();   //使用锁对象this是obj对象
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj2.mm();  //使用锁对象this是obj2对象
            }
        }).start();
    }
        public void mm(){
        //经常使用this当前对象作为锁对象
        synchronized (this){
            for (int i=1;i<=100;i++){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }
}


