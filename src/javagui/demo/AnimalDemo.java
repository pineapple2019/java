package demo;

class Animal{
    public int age=40;
    public void eat(){
        System.out.println("����Զ���");
    }
}
class Cat extends Animal{
    public int age=20;
    public int weight=10;
    @Override
    public void eat() {
        System.out.println("è����");
    }
    public void playGame(){
        System.out.println("è׽�Բ�");
    }
}
public class AnimalDemo {
    public static void main(String[] args) {
        //��������ָ���������
        Animal a=new Cat();
        System.out.println(a.age);
        a.eat();
        /**
         *  System.out.println(a.weight);
         *  a.playGame();
         *  �������ᱨ����Ϊ������û��playGame��weight
         */
    }
}
