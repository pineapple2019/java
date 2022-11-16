package itheima7;

interface Inter{
    void method();
}

public class Outer {
    public static void main(String[] args) {
//        new Inter(){
//            @Override
//            public void show(){
//                System.out.println("匿名内部类");
//            }
//        };
    //编译看左边，执行看右边



        new Inter(){
            @Override
            public void method() {
                System.out.println("我是匿名内部类");
            }
        }.method(); //直接调用方法
        new Inter(){
            @Override
            public void method() {
                System.out.println("我是匿名内部类");
            }
        }.method(); //直接调用方法

        //如果想要多调用几次，那么就多复制几份



    }
}
