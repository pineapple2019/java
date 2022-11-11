package 多线程.wkcto.wait;

/**
 * wait()/notify()方法需要放到同步代码块中，否则会报错异常，
 * 任何对象都可以调用wait（）/notify（）这两个方法是从object类继承的
 *
 */
public class Test01 {
    public static void main(String[] args) {

        try {
            String test = "wkcto";
            test.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

