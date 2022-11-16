package tree;

import java.util.Arrays;
import java.util.Comparator;

public class TestCompartor {

    public static class Dog {
        public String name;
        public int price;

        public Dog(String name,int price){
            this.name=name;
            this.price=price;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static void main(String[] args) {
        Dog a = new Dog("fd",423);
        //Comparator比较器的使用
        Dog[] dogs = {
              new Dog("WC1",900),
             new Dog("WC2",500),
               new Dog("WC3",200),
                new Dog("WC4",700),
                new Dog("WC5",400)
        };

        //比较器
        Comparator<Dog> dogComparator = new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.price-o2.price;
            }
        };

        //使用比较器排序
        Arrays.sort(dogs,dogComparator);
        //输出打印
        Arrays.asList(dogs).forEach(System.out::println);
    }
}
