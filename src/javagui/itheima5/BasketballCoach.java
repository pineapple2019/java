package itheima5;

public class BasketballCoach extends Coach {
    //如果要继承，那么就要实现继承的方法

    @Override
    public void teach() {
        System.out.println("篮球教练如何运球和投篮");
    }

    @Override
    public void eat() {
        System.out.println("篮球教练，吃肉喝奶");
    }
}
