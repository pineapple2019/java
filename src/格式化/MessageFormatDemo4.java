import java.text.MessageFormat;
import java.util.Scanner;

/**
 * @Author: 从南到北
 * @Date: 2022/03/10/22:22
 */
public class MessageFormatDemo4 {
    public static void main(String[] args) {
        //对于一个类的添加
        /**
         * 添加类
         *     <Declaration>
         *         <Class IRI="#主存"/>
         *     </Declaration>
         * inputExample： addClass 存储资源  主存
         */
        //按照这个规则添加
        MessageFormat form = new MessageFormat(
                "<Declaration>\n" +
                "<Class IRI=\"#{0}\">\n" +
                "</Declaration>");
        String[] testArgs = {"电脑"};
        System.out.println(form.format(testArgs));

        //试一试，根据你输入的内容，然后进行添加，或者是有选择的添加
        //首先，你得获取从键盘输入的内容
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要添加的资源");
        String s = sc.nextLine();
        System.out.println(form.format(s));


    }
}
