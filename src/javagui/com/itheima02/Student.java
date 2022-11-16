package com.itheima02;

public class Student {
    //��Ա������һ��˽�У�һ��Ĭ�ϣ�һ������
    private String name;
    int age;
    public String address;

    //���췽����һ��˽�У�һ��Ĭ�ϣ���������
    public Student() {
    }

    private Student(String name) {
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //��Ա������һ��˽�У��ĸ�����
    private void function() {
        System.out.println("function");
    }

    public void method1() {
        System.out.println("method");
    }

    public void method2(String s) {
        System.out.println("method:" + s);
    }

    public String method3(String s, int i) {
        return s + "," + i;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
