package 内部类;

/**
 * 内部类分为两种：
 * 成员内部类
 * 局部内部类：实际使用的是：匿名内部类
 *
 */


public class Outer {
    int i  = 1;
    //这是个成员内部类，因为位置和成员变量是一样的
    class Inner {
        int i  = 2;
        public void inner(){
            int i = 3;
            System.out.println(Outer.this.i);
        }

    }

    public static void main(String[] args) {

        //成员内部类的访问：通过外部类对象进行访问
        Outer.Inner a = new Outer().new Inner();
        a.inner();
        System.out.println("内部类的成员变量："+a.i);

    }
}