//package com.kuang.annotation;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
////自定义注解
//public class test03 {
//    //注解可以显示赋值，如果没有默认值，我们必须给注解赋值
//    @MyAnnotation2(age=18,name = "秦疆");
//    public void test(){}
//
//}
//@Target({ElementType.TYPE,ElementType.METHOD})
//@Retention(RetentionPolicy.RUNTIME)
//@interface MyAnnotation2{
//    //注解的参数：参数类型+参数名（）
//    String name() default "";
//    int age();
//    int id() default -1;    //如果默认值为-1，代表不存在
//
//    String[] schools() default {"西部开源","清华"};
//}
//@interface MyAnnotation3{
//
//}