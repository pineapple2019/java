/**
 * @Author: 从南到北
 * @Date: 2022/03/10/21:25
 */
public class RegexDm2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] str = new String[]{"Rudolph","[rR]udolph","[rR][aeiou][a-z]ol.*","R.*"};
        for(String pattern:str)
            System.out.println("Rudolph".matches(pattern));

        for(String ss:str)//是将容器str内的数据以String类型的数据一个一个的遍历出来.
            System.out.println(ss);

        for(int i=0;i<str.length;i++)
            System.out.println(str[i]);

    }
}
