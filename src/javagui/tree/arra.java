package tree;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: ���ϵ���
 * @Date: 2022/04/02/11:31
 */
public class arra {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("AA", "BB");
        //��һ��
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //�ڶ���
        for (String s : list) {
            System.out.println(s);
        }

        //������ lambda ���ʽ
        list.forEach(s-> System.out.println(s));

    }
}
