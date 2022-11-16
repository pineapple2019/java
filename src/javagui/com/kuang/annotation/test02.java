package com.kuang.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//测试元注解
public class test02 {
    public void test(){
    }
}

//定义一个注解
//Target 表示我们的注解可以用在什么地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})

//Retention，表示我们的注解 在什么地方还有效
//runtime>class>sources
@Retention(value = RetentionPolicy.RUNTIME)
//Inherited 子类 可以继承父类的注解
@interface MyAnnotation{

}
