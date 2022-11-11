package 多线程.wkcto.intrinsiclock;

/**
 * 同步方法与同步代码块如何选择
 * 同步方法锁的粒度粗, 执行效率低, 同步代码块执行效率高
 */
public class Test07 {

    public static void main(String[] args) {
        final Test07 obj = new Test07();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.doLongTimeTask();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.doLongTimeTask2();
            }
        }).start();
    }

    /**
     * //同步方法, 执行效率低
     */
    public void doLongTimeTask(){
        try {
            System.out.println("TaskBegin1"+"begin = " + System.currentTimeMillis());
            //模拟任务需要准备 3 秒钟
            Thread.sleep(3000);
            synchronized (this){
                for (int i = 1;i<=100;i++){
                    System.out.println(Thread.currentThread().getName()+"---"+i);
                }
            }
            System.out.println("TaskEnd1"+"end = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * //同步代码块,锁的粒度细, 执行效率高
     */
    public synchronized void doLongTimeTask2(){
        try {
            System.out.println("TaskBegin2"+"begin = " + System.currentTimeMillis());
            Thread.sleep(3000);
                for (int i = 1;i<=100;i++){
                    System.out.println(Thread.currentThread().getName()+"---"+i);
                }
            System.out.println("TaskEnd2"+"end = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
