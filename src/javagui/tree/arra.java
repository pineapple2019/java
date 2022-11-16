package tree;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: 从南到北
 * @Date: 2022/04/02/11:31
 */
public class arra {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("AA", "BB");
        //第一种
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //第二种
        for (String s : list) {
            System.out.println(s);
        }

        //第三种 lambda 表达式
        list.forEach(s-> System.out.println(s));

    }
}
