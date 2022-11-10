package test1;

/**
 * @Author: 从南到北
 * @Date: 2022/03/10/21:05
 */
public class RegexDm2 {
    public static void main(String[] args){
        String s = "12342jasfkgnas234";
        //把字符串里面的数字替换成*
        String regex = "\\d";
        String ss = "*";
        String result = s.replaceAll(regex,ss);
        System.out.println(result);

    }
}
