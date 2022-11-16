package itheima11;
/*
    哈希值：
        是JDK根据对象的地址或者字符串或者数字算出来的int类型的数值

    Object类中有一个方法可以获取对象的哈希值
        public int hashCode()：返回对象的哈希码值
 */
public class HashDemo {
    public static void main(String[] args) {
        //创建学生对象
        Student s1=new Student("林青霞",30);
        //同一个对象多次调用hashCode()方法，返回的哈希值是相同的
        System.out.println(s1.hashCode());
        System.out.println(s1.hashCode());

        Student s2 = new Student("林青霞", 30);
//        //默认情况下，不同对象的哈希值是不同的
//        //通过方法重写，可以实现不同对象的哈希值相同
          System.out.println(s2.hashCode());
        System.out.println("----------");
        System.out.println("hello".hashCode());
        System.out.println("world".hashCode());
        System.out.println("java".hashCode());

        System.out.println("world".hashCode());
        System.out.println("----------");

        System.out.println("重地".hashCode());        //1179395
        System.out.println("通话".hashCode());        //1179395
    }
}
