package 字符串;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class TestToString {
//    @Test
//    public void a(){
//        Random r = new Random();
//        int a = r.nextInt(100);
//        System.out.println(a);
//        System.out.println(r.toString());
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(scanner.toString());
//    }
//    @Test
//    public void stringDemo(){
//        String str = "itcast";
//        System.out.println(str);
//        str = "itheima";
//        System.out.println(str);
//    }
//    @Test
//    public void stringDemo2(){
//        String str1 = new String("abc");
//        String str2 = "abc";
//
//        System.out.println(str1);
//        System.out.println(str2);
//        System.out.println(str1 == str2);
//        System.out.println(str1.equals(str2));
//    }
//    @Test
//    public void function_7(){
//        String str = "abc";
//        //调用String类方法getBytes字符串转成字节数组
//        byte[] bytes = str.getBytes();
//        for(int i = 0 ; i < bytes.length ; i++){
//            System.out.println(bytes[i]);
//        }
//    }

    public static void main(String[] args) {
//        String str = "A%A3eBr1FFy";
//        getCount(str);
        char a = '%';
        char b = '2';
        //对于一个字符char类型的，如果是''表示的，那么就是字符，如果是不带''表示的，那么就是ascii码的表示形式
        String c = "4353";

        System.out.println((int)a);
        System.out.println(b);
    }


    public static void getCount(String str){
        //定义三个变量,计数
        int upper = 0;
        int lower = 0;
        int digit = 0;
        //对字符串遍历

        //数字0-9，ascii码是48-57
        //小写字母:97-122
        //大写字母:65-90

        for(int i = 0 ; i < str.length() ; i++){
            //String方法charAt,索引,获取字符
            char c = str.charAt(i);
            //利用编码表 65-90  97-122  48-57
            if(c >='A' && c <='Z'){
                upper++;
            }else if( c >= 'a' && c <= 'z'){
                lower++;
            }else if( c >= '0' && c <='9'){
                digit++;
            }
        }
        System.out.println(upper);
        System.out.println(lower);
        System.out.println(digit);

    }
}
