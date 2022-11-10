package test1;

import java.util.Scanner;
//案例：判断录入的手机号是否为13或者18开头
public class RegexDm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机好：");
        String s = sc.nextLine();
        String regex = "1[38]\\d{9}";//定义手机好规则
        boolean flag = s.matches(regex);//判断功能
        System.out.println("flag:"+flag);
    }
}
