package ee.ds;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please input a str1: ");
        String str1 = sc.nextLine();

        System.out.print("Please input a num1: ");
        int num1 = sc.nextInt();

        System.out.print("Please input a str2: ");
        String str2 = sc.nextLine();

        System.out.print("Please input a num2: ");
        float num2 = sc.nextFloat();

        System.out.print("Please input a str3: ");
        String str3 = sc.nextLine();

        System.out.println("\n***********输出：****************");
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = " + str3);
    }
}
