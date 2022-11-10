package dream0519.dream123;

import java.util.Scanner;

//进阶，使用输入输出，提供更好的服务，而不是传参
public class dream02 {
    //资源，能力，服务
    public static void main(String[] args) {
        //new 一个秘书
        secretary02 lisa =  new secretary02();
        //秘书提供计算服务
        lisa.calculator();
    }
}
//实现计算器功能
class secretary02{
    //服务
    public void calculator(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要的操作");
        String operate = input.nextLine();
        //上面的放到最后面就不行了，但是可以试试能不能改成next
        System.out.println("请输入你要计算的两个数字");
        int a = input.nextInt();
        int b = input.nextInt();

       //能力
       //改进版就是请输入两个数，现在先是直接传参

        int sum=0;
       switch (operate){
           case "+":
               sum = a+b;
               break;
           case "-":
               sum = a-b;
               break;
           case "*":
               sum = a*b;
               break;
           case "/":
               sum = a/b;
               break;
           default:
               System.out.println("传参有误！");
       }
        System.out.println("计算结果为："+sum);
    }
}
