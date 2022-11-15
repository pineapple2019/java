package 内部类;

/**
 * 匿名内部类：是创建某个类型  子类对象  的快捷方式
 */

//定义一个抽象类
abstract class Person{
    //抽象类不用方法体，只有方法名
    public abstract void eat();

}

public class 匿名内部类 {
    public static void main(String[] args) {
        //创建父类的子类对象，并用多态的方式赋给父类的引用变量
        Person p = new Person(){
            @Override
            public void eat() {
                System.out.println("我吃过了");
            }
        };

        //调用eat方法
        p.eat();

        //使用匿名对象的方式，就是说，不定义变量引用。
        new Person(){
            public void eat(){
                System.out.println("这个是使用匿名内部类实现的");
            }
        }.eat();

    }

}
