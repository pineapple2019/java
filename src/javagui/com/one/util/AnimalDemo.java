package com.one.util;

public class AnimalDemo {
    public static void main(String[] args) {
        //创建对象，调用方法,首先，用接口来做，
        Jumpping j=new Cat();
        j.jump();//接口里面只有一个方法

        Animal a=new Cat();
        a.setName("加肥");
        a.setAge(5);
        System.out.println(a.getName()+","+a.getAge());
        a.eat();
        a=new Cat("加肥",5);
        System.out.println(a.getName()+","+a.getAge());
        a.eat();
    }
}
