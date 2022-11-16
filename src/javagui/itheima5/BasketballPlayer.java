package itheima5;

//继承，要重写父类中的方法，可以不重写吗？？
//子类一定要重写父类中的抽象类

public class BasketballPlayer extends Player{
    public BasketballPlayer() {
    }
    public BasketballPlayer(String name, int age) {
        super(name, age);
    }
    @Override
    public void study() {
        System.out.println("篮球运动员学习投篮和运球");
    }
    //这个父类没有？爷爷？
    @Override
    public void eat() {
        System.out.println("篮球运动员吃牛肉，喝牛奶");
    }
}
