package 多线程.wkcto.threadmehtod.p6priority;

public class Test {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.setPriority(1);
        threadA.start();

        ThreadB threadB = new ThreadB();
        //数字越大，优先级越高，理论上获得cpu的资源越多
        threadB.setPriority(10);
        threadB.start();
    }
}


