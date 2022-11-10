import java.util.Scanner;

/**
 * @Author: 从南到北
 * @Date: 2022/03/10/21:15
 * 效验QQ号（要求：5-15位数字，0不能开头）
 */
public class RegexDm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的QQ号码：");
        String qq = sc.nextLine();
        System.out.println("checkQQ:"+checkQQ(qq));
    }

    private static boolean checkQQ(String qq) {
        return qq.matches("[1-9]{1}\\d{4,14}");
    }

}
