package tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: 从南到北
 * @Date: 2022/04/02/12:01
 */
public class ArraytoString {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        Integer[] arrs = new Integer[list.size()];
        list.toArray(arrs);
//        System.out.println(arrs);

//        System.out.println(Arrays.toString(arrs));

    }
}
