package dream0519.dream123;
//成功实现计算器小例子
//知识点，传参，switch条件语句
public class dream01 {
    //资源，能力，服务
    public static void main(String[] args) {
        //new 一个秘书
        secretary01 lisa =  new secretary01();
        //秘书提供计算服务
        lisa.calculator(1,2,"/");

    }
}
//实现计算器功能
class secretary01{
    //服务
    public void calculator(int a,int b,String operate){
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
        System.out.println(sum);
    }
}
