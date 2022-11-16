package itheima5;

//抽象的运动员类
public abstract class Player extends Person {
    public Player() {
    }

    public Player(String name, int age) {
        super(name, age);
    }
    public abstract void study();   //抽象的学习方法
}
