package tree;

import java.util.Arrays;
import java.util.Comparator;


class Dog1{
    public String name;
    public int price;
    public Dog1(String name,int price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dog1{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class TestCompartor1 {

//    public static class Dog {
//        public String name;
//        public int price;
//
//        public Dog(String name,int price){
//            this.name=name;
//            this.price=price;
//        }
//
//        @Override
//        public String toString() {
//            return "Dog{" +
//                    "name='" + name + '\'' +
//                    ", price=" + price +
//                    '}';
//        }
//    }

    public static void main(String[] args) {

        //Comparator比较器的使用
//        TestCompartor1.Dog1[] dogs = {
//              new TestCompartor.Dog("WC1",900),
//                new TestCompartor.Dog("WC2",500),
//                new TestCompartor.Dog("WC3",200),
//               new TestCompartor.Dog("WC4",700),
//               new TestCompartor.Dog("WC5",400)
//        };
    Dog1[] dogs = {
              new Dog1("WC1",900),
                new Dog1("WC2",500),
                new Dog1("WC3",200),
               new Dog1("WC4",700),
               new Dog1("WC5",400)
        };

//        比较器
        Comparator<Dog1> dogComparator = new Comparator<Dog1>() {
            @Override
            public int compare(Dog1 o1, Dog1 o2) {
                return o1.price-o2.price;
            }
        };
        //使用比较器排序
        Arrays.sort(dogs,dogComparator);
        //输出打印
        Arrays.asList(dogs).forEach(System.out::println);
    }
}
