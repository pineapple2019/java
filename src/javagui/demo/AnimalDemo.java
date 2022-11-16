package demo;

class Animal{
    public int age=40;
    public void eat(){
        System.out.println("动物吃东西");
    }
}
class Cat extends Animal{
    public int age=20;
    public int weight=10;
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
    public void playGame(){
        System.out.println("猫捉迷藏");
    }
}
public class AnimalDemo {
    public static void main(String[] args) {
        //父类引用指向子类对象
        Animal a=new Cat();
        System.out.println(a.age);
        a.eat();
        /**
         *  System.out.println(a.weight);
         *  a.playGame();
         *  这两个会报错，因为父类中没有playGame和weight
         */
    }
}
