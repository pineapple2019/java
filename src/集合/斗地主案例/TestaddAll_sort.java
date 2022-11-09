package 集合.斗地主案例;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TestaddAll_sort {
    public static void main(String[] args) {

        ArrayList<String> number = new ArrayList<>();
        Collections.addAll(number,"3","4","5","6","7","8","9","10","J","Q","K","A","2","1");

        ArrayList<String> number1 = new ArrayList<>();
        number1.add("1");
        number1.add("2");
        number1.add("3");
        number1.add("5");
        number1.add("k");

        Collections.sort(number1);
        //遍历输出结果
        for (String a : number1){
            System.out.println(a);
        }

    }
}
