package jiheset;

import java.util.HashSet;

/**
 * @Author: ���ϵ���
 * @Date: 2022/04/05/14:13
 * û��������û���ظ�Ԫ��
 *
 */
public class SetDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("world");
        set.add("java");
        //��Ϊû������������ֻ��ʹ��forѭ��
        for (String s:
                set ) {
            System.out.println(s);
        }
    }
}
