package 多线程.wkcto.intrinsiclock;


/**
 * synchronized同步静态方法
 *      把整个方法体作为同步代码块
 *      默认的锁对象是当前类运行时类对象，Test06.class。有人称它为类锁
 *
 */
public class Test09 {
    public static void main(String[] args) {
        final Test09 obj = new Test09();

        //一个线程调用mm方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();   //使用锁对象Test06.class
            }
        }).start();

        //一个线程调用mm2方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                //静态方法，通过类名来调用
                Test09.mm2();  //使用锁对象Test06.class
            }
        }).start();

}

    public void mm(){
        //使用当前类的【运行时类对象】作为锁对象，可以简单理解为把Test06类的字节码文件作为锁对象
        //专业说法“运行时类对象
        synchronized (Test09.class){
            for (int i=1;i<=100;i++){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
                if ( i == 50){
                    //把字符串转换为int 类型时,如果字符串不符合 数字格式会产生异常
                    Integer.parseInt("abc");
                }
            }

        }
    }

    //使用synchronized修饰静态方法，同步静态方法，默认运行时类Test06.class作为锁对象
    public synchronized static void mm2(){
            for (int i=1;i<=100;i++){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }

}


