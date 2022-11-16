package com.hspedu.reflection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //根据配置文件 re.properties 指定信息，创建  cat对象，并调用方法hi
        //尝试用反射做
        Properties properties = new Properties();
        properties.load(new FileInputStream("swingDemo\\src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName =  properties.get("method").toString();
        System.out.println("classfullpath="+classfullpath);
        System.out.println("method"+methodName);
        //使用反射机制创建对象
        //加载类
        Class cls = Class.forName(classfullpath);
        //通过cls得到加载的类，com.hspedu.Cat的对象实例
        Object o= cls.newInstance();
        System.out.println("o的运行类型"+o.getClass());   //运行类型
        //在反射中，把方法视为对象（万物即对象）
//      Method method1=cls.getMethod(methodName);

    }
}
