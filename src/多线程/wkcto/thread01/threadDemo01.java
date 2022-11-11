package 多线程.wkcto.thread01;

public class threadDemo01 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        /**
            这种单纯的调用run（）方法，仍然是单线程
            执行的结果是按顺序执行，
            先执行t1的run方法
            再执行t2的run方法
         */
        t1.run();
        System.out.println("1-------------------");
        t2.run();
        System.out.println("2------------------");
        /**
         * start(),线程开始执行，java虚拟机调用此线程的run方法
           此时就是抢占式的执行了，t1和t2会抢占式的输出结果，
           不会按照顺序输出！
         */
        t1.start();
        System.out.println("3-------------------");
        t2.start();

    }
}




