package 创新大厦;

public class Person {
    private String name;
//    public String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person xiaoZhang = new Person("小张");
        Person xiaoLi = new Person("小李");
        swap(xiaoZhang, xiaoLi);
        System.out.println("xiaoZhang:" + xiaoZhang.getName());
        System.out.println("xiaoLi:" + xiaoLi.getName());
    }

    /**
     *运行结果：
     * person1:小李
     * person2:小张
     * xiaoZhang:小张
     * xiaoLi:小李
     */
    public static void swap(Person person1, Person person2) {
        Person temp = person1;
        person1 = person2;
        person2 = temp;
        System.out.println("person1:" + person1.getName());
        System.out.println("person2:" + person2.getName());
    }


    /**
     *
     *      * 大家以为的
     *      *     Person temp = person1;
     *      *     person1 = person2;
     *      *     person2 = temp;
     *      * 其实是：请看情况1和2
     */
    /**
     * 情况1
     *  这里，
     *  1,是因为name属性是private，所以修改名字，必须用set方法（可以看出，private对数据的保护还是很给力的！）
     *  2,temp要改为String类型，因为name属性是String类型
     * swap2运行结果：
         * person1:小李
         * person2:小张
         * xiaoZhang:小李
         * xiaoLi:小张
     * 修改成功！
     */
    public static void swap2(Person person1, Person person2) {
        String temp = person1.getName();
        person1.setName(person2.getName());
        person2.setName(temp);
        System.out.println("person1:" + person1.getName());
        System.out.println("person2:" + person2.getName());
    }

    /**
     * 情况2
     * 1，temp改为了string类型
     * 2，name属性变为public
     * swap3运行结果：
         * person1:小李
         * person2:小张
         * xiaoZhang:小李
         * xiaoLi:小张
     * 修改成功！
     */
    public static void swap3(Person person1, Person person2) {
        String temp = person1.name;
        person1.name = person2.name;
        person2.name = temp;
        System.out.println("person1:" + person1.getName());
        System.out.println("person2:" + person2.getName());
    }
    /**
     * 总结：所以，如果要看是否会修改到某个值，就看temp的类型，
     *  如果是String类型，说明修改到name属性
     *  如果是person类型，说明也就只是person的一个地址罢了，如果只是地址的交换，并不会影响到实参的内容改变
     *  总结：
     *  java是值传递，（如果要传参，那么只会复制栈中的内容）
     *  对于基本数据类型直接复制一份基本数据类型数据
     *  对于引用数据类型：复制一份引用数据类型的地址 （这里的前提要熟记基本数据类型存放在栈中，引用数据类型的地址存放在栈中，数据存放在堆中，因为一般都比较大，堆中内存大）
     */



}
