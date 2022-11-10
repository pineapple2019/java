package com.itheima_02;

public class Student {
    private  int age;
    public  String name;
    public String sex;

    //一个私有，一个默认，两个公共
    public Student() {
    }

    private Student(int age) {
        this.age = age;
    }

    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Student(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    //成员方法：一个私有，四个公共
   private void function(){
       System.out.println("function");
   }
   public void method1(){
       System.out.println("method1");
   }
    public void method2(String s){
        System.out.println("method2："+s);
    }
    public String method3(String s,int i){
        return s+","+i;
    }

    //重写toString，意思就是你如果要sout输出这个对象，会输出什么结果
    @Override
    public String toString() {
        return "Student{"+
                "name="+name+","+
                ",age="+age+","+
                ",sex="+sex+"}";
    }


}
