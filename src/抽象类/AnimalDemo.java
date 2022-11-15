package 抽象类;

/*测试类*/
public class AnimalDemo {
    public static void main(String[] args) {
        //创建对象，按照多态的方式
        Animal a = new Cat();
        a.setName("小猫");
        a.setAge(1);
        System.out.println(a.getName()+","+a.getAge());
        a.eat();
        System.out.println("--------");
        a = new Dog("小狗",2);
        System.out.println(a.getName()+","+a.getAge());
        a.eat();
    }
}

class Cat extends Animal {
    public Cat() {
    }
    public Cat(String name, int age) {
        super(name, age);
    }
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

class Dog extends Animal {
    public Dog() {
    }
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}

abstract class Animal {
    private String name;
    private int age;
    public Animal() {
    }
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void eat();
}


