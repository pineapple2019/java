package jihe;

import java.util.ArrayList;

/**
 * @Author: 从南到北
 * @Date: 2022/04/02/12:49
 */
public class ArrayListDemo01 {
    public static void main(String[] args) {

        ArrayList<String> array = new ArrayList<>();
        array.add("hello");
        array.add("world");
        array.add("java");

        array.add(1,"javase");
        System.out.println("array集合结果:"+array);
        //增加修改删除查
        //add
        //set
        //remove
        //get


    }
}
