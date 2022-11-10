package dream0519.dream123;

import java.util.Scanner;

public class Test_nextLine {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.println("请输入两个字符串作为next()的接收值");

        /*参见下文输入输出图片，此处next()方法过滤了"ab"前面的空格，遇到"ab"后的空格后结束了输入，最后得到的结果是"ab"，
        同样"cd"前的空格被next()方法当做无效字符过滤，但是"ef"前的空格并没有被next()方法读取，其会作为nextLine()的有效字符被nextLine()读取，
        直到nextLine()遇到Enter为止；,Enter会被nextLine()当做无效字符，接着str4开始读取"gh df"直到遇到Enter后结束*/
        String str1=input.next();
        String str2=input.next();
        System.out.println("str1="+str1);
        System.out.println("str2="+str2);
        System.out.println("请输入两个字符串作为nextLine()的接收值");
        String str3=input.nextLine();
        String str4=input.nextLine();
        System.out.println("str1="+str3);
        System.out.println("str2="+str4);

    }
}
