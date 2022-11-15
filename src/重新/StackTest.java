package 重新;

/**
 * @Author: 从南到北
 * @Date: 2022/01/04/23:47
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        //遍历
        for (String item:stack){
            System.out.println(item);
        }
        System.out.println("-----------");
        //弹栈
        String result = stack.pop();
        System.out.println(result);

        System.out.println("剩余元素个数："+stack.size());
    }
}
