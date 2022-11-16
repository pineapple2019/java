package com.one.util;

public class InterfaceDemo {
    public static void main(String[] args) {
        Inter i=new InterImpl();    //通过多态的方式创建了对象
//        i.num=10;
        System.out.println(i.num);
        System.out.println(i.num2);
        System.out.println(Inter.num);  //可以通过接口名，直接访问，说明，这个变量是静态变量，是用static修饰的
    }
}
