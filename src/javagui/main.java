package ee.ds;

import java.util.Scanner;

public class main {
    /**
     * next()、nextLine()、nextInt()三者的区别，以及要知道hasnext()的作用,或者说不知道也行，知道如何用就行
     * 主要是对空格的区别，
     * nextLine()将输入的空格作为字符一并输入，然后每次输入的数据是一行  输出字符串
     * next()将空格作为区别 ,就是当你输入一个空格时，本次输入就算结束了，空格后面的数据不会输出
     * 输出字符串
     * nextInt()将空格作为区别，但是输入的数据只能是int  输出int
     *
     */
    public static void main(String[] args) {
//        testnext();
            testnextLine2();
    }
    /**
     * 对三者进行测试
     */
    public static void testnext(){
        // next()将空格作为区别 ,就是当你输入一个空格时，本次输入就算结束了
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        System.out.print(next);
    }

    /**
     * 测试连续输入
     */
    public static void testnext1(){
        // next()将空格作为区别 ,就是当你输入一个空格时，本次输入就算结束了
        Scanner sc = new Scanner(System.in);//输入的内容
        while(sc.hasNext()){
            String next = sc.next(); //获取输入的内容
            if (next.equals("结束")){
                break;
            }
            System.out.println(next); //我想知道，这个next能够存多少个数据呢？
        }
    }

    /**
     * 测试nextLine()
     * */
    public static void testnextLine(){
        // next()将空格作为区别 ,就是当你输入一个空格时，本次输入就算结束了
        Scanner sc = new Scanner(System.in);//输入的内容
        String s = sc.nextLine();
        System.out.print(s);
        System.out.print("图片说，nextLine()会以\n换行为结束单位，并且会读取换行，所以，这一句话，会在下一行吗，还是说就是跟在我输入内容的后面呢");
        String s1 = sc.nextLine();
        System.out.print(s1);
        /**
         * 得出结论，nextline()是以\n换行为结束标志，但是读到这个的时候，不会将其输出，并且如果下一个还是nextLine()，你直接输出一个回车，
         * nextLine检查到回车会直接结束，输出内容为null，并不会受到上一个nextLine的影响。
         */
    }
    public static void testnextLine1(){
        // next()将空格作为区别 ,就是当你输入一个空格时，本次输入就算结束了
        Scanner sc = new Scanner(System.in);//输入的内容
        while(sc.hasNext()){
            String s = sc.nextLine();
            if(s.equals("结束")){
                break;
            }
            System.out.println(s);
        }
    }

    public static void testnextLine2(){
        // next()将空格作为区别 ,就是当你输入一个空格时，本次输入就算结束了
        Scanner sc = new Scanner(System.in);//输入的内容
        String s = sc.next();
        System.out.print(s);
        System.out.print("图片说，nextLine()会以\n换行为结束单位，并且会读取换行，所以，这一句话，会在下一行吗，还是说就是跟在我输入内容的后面呢");
        String s1 = sc.nextLine();
        System.out.print(s1);
        /**
         * 得出结论，nextline()是以\n换行为结束标志，但是读到这个的时候，不会将其输出，并且如果下一个还是nextLine()，你直接输出一个回车，
         * nextLine检查到回车会直接结束，输出内容为null，并不会受到上一个nextLine的影响。
         */
    }






}


