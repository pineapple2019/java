package 集合.增强for;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class function_1 {
    public static void main(String[] args) {
       List list = new ArrayList();

       list.add("abc");
       list.add("itcast");
       list.add(5);

       Iterator it = list.iterator();

       while(it.hasNext()){
           String str = (String)it.next();
           System.out.println(str);
       }


    }
}
