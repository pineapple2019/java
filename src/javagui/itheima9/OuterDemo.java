package itheima9;

interface Inter{
    void show();
}

class Outer {
    public void method(){
        //这就是一个匿名内部类
        //这样写仅仅是一个对象
//        new Inter(){
//            @Override
//            public void show() {
//                System.out.println("匿名内部类");
//            }
//        };
//  这样写就是对象调用了方法
//        new Inter(){
//            @Override
//            public void show() {
//                System.out.println("匿名内部类");
//            }
//        }.show();
//
//        new Inter(){
//            @Override
//            public void show() {
//                System.out.println("匿名内部类");
//            }
//        }.show();

        Inter i= new Inter(){       //按照多态的形式,这个对象Inter一定是接口的实现类对象或者或者是类的子类对象
            @Override
           public void show() {
                System.out.println("匿名内部类");
            }
        };
        i.show();   //编译看左边，执行看右边
        i.show();   //多次调用


    }
}
public class OuterDemo{
    public static void main(String[] args) {
        Outer o=new Outer();
        o.method();
    }
}


