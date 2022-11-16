package itheima;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Apple
{
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws Exception{
        //使用反射调用对象
        Class clz = Class.forName("itheima.Apple");
        //使用反射调用
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        Constructor appleConstructor=clz.getConstructor();
        Object appleObj = appleConstructor.newInstance();
        setPriceMethod.invoke(appleObj,14);
        Method getPriceMethod=clz.getMethod("getPrice");
        System.out.println(getPriceMethod.invoke(appleObj));
    }
}
