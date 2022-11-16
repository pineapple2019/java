package itheima8;

/**
 * 跳高接口
 */
interface Jumpping{
    void jump();
}

/**
 * 实现接口
 */
class Cat implements Jumpping{
    @Override
    public void jump() {
        System.out.println("猫可以跳高");
    }
}

class Dog implements Jumpping{
    @Override
    public void jump() {
        System.out.println("狗可以跳高");
    }
}

/**
 * 接口操作类，里面有一个方法，方法的参数是接口名
 */
class JumppingOperator{
    public void method(Jumpping j){
        j.jump();
    }
}

public class JumppingDemo {
    public static void main(String[] args) {
        //需求：创建接口操作类对象，调用method方法
        JumppingOperator jo=new JumppingOperator();
        Jumpping j=new Cat();
        jo.method(j);

        Jumpping j2=new Dog();
        jo.method(j2);
        //。。。
        //如果有很多动物，那么就很冗余，匿名内部类可以很好的解决
        System.out.println("---------");

        //匿名内部类
        jo.method(  //这个方法要的是一个接口，其实是接口的实现类对象，
                    //而匿名内部类的格式他的本质就是实现类对象，并且是实现了该接口的对象，

          new Jumpping() {      //这个就和猫完全没有关系，把猫删了也可，
              //所以，采用后面这两种形式，不需要多写两个类出来，

            @Override
            public void jump() {
                System.out.println("猫可以跳高");
            }
        }

        );

        //匿名内部类简化
        jo.method(new Jumpping() {
            @Override
            public void jump() {
                System.out.println("狗可以跳高");
            }
        });

    }

}
