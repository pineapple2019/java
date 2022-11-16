package jiheset;

import java.util.HashSet;

/**
 * @Author: 从南到北
 * @Date: 2022/04/05/14:13
 * 没有索引，没有重复元素
 *
 */
public class SetDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("world");
        set.add("java");
        //因为没有索引，所以只能使用for循环
        for (String s:
                set ) {
            System.out.println(s);
        }
    }
}
