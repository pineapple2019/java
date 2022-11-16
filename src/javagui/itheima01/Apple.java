package itheima01;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Apple {
    private int price;
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public static void main(String[] args) throws Exception{
        //正常调用
        Apple apple = new Apple();
        apple.setPrice(15);
        System.out.println("apple price------------"+apple.getPrice());
        //使用反射调用
        Class clz = Class.forName("itheima01.Apple");
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        Constructor  appleConstructor = clz.getConstructor();
        Object appleObj = appleConstructor.newInstance();
        setPriceMethod.invoke(appleObj,14);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("Apple price:"+getPriceMethod.invoke(appleObj));
    }
}
