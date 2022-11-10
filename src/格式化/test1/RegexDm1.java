package test1;

import java.util.Scanner;

/**
 * @Author: 从南到北
 * @Date: 2022/03/10/21:00
 */

public class RegexDm1 {
    public static void main(String[] args){
        String age = "18-24";//定义年龄范围
        String regex = "-";
        String[] strArr = age.split(regex);//分割成字符串数组

        int startAge = Integer.parseInt(strArr[0]);
        int endAge = Integer.parseInt(strArr[1]);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的年龄：");
        int a = sc.nextInt();
        if (a >= startAge && a <= endAge){
            System.out.println("你就是我想找的");
        }else{
            System.out.println("滚");
        }
    }
}
