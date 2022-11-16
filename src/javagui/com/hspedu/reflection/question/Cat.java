package com.hspedu.reflection.question;

public class Cat {
    private String name="招财猫";
    private void hi(){
        //常用方法
        System.out.println("hi"+name);
    }

    //当我们需要调用cry方法的时候，就需要修改源码，而现在有了反射，只需要修改配置文件
    public void cry(){
        System.out.println(name+"喵喵叫。。。");
    }
}
