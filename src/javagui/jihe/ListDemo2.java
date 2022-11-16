package jihe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: 从南到北
 * @Date: 2022/04/02/21:42
 * 三种遍历方式，遍历学生
 */
public class ListDemo2 {
    public static void main(String[] args) {
        //创建集合对象
        List<Student> list = new ArrayList<>();

        //创建学生对象
        Student s1 = new Student("大公",10);
        Student s2 = new Student("大诚",20);
        Student s3 = new Student("大勇",30);
        Student s4 = new Student("大毅",30);

        //把学生添加到集合
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        //迭代器，集合特有的遍历方式
        Iterator<Student> it = list.iterator();
        while(it.hasNext()){//当前元素是否有值
            Student s = it.next();
            System.out.println(s.getName()+","+s.getAge());
        }
        System.out.println("------------------");
        //普通for：带有索引的遍历方式
        for(int i=0;i<list.size();i++){
            Student s = list.get(i);
            System.out.println(s.getName()+","+s.getAge());
        }
        System.out.println("------------------");

        //增强for的方式：最方便的遍历方式
        for (Student s:list){
            System.out.println(s.getName()+","+s.getAge());
        }


    }
}
