package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ���ϵ���
 * @Date: 2022/04/02/12:08
 * ���Ϻ������ת��
 */
public class array1 {
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6};

        List<Integer> list = new ArrayList<Integer>();
        list = Arrays.asList(new Integer[list.size()]);
        Integer arrs[] =  list.toArray(new Integer[list.size()]);
        System.out.println(arrs);
    }
}
