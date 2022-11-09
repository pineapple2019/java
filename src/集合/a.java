package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class a {
    public static void main(String[] args) {
        Collection objects = new ArrayList();
        objects.add("a");
        objects.add("b");
        objects.add("c");
        objects.add("d");

        Iterator it = objects.iterator();
        while(it.hasNext()){
            String str = (String)it.next();
            System.out.print(str);
        }
    }
}



