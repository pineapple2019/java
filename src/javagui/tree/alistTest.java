package tree;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: ���ϵ���
 * @Date: 2022/04/02/11:37
 */
public class alistTest {
    public static void main(String[] args) {
        String s[]={"aa","bb","cc"};

        List<String> sList= Arrays.asList(s);
        for(String str:sList){//�ܱ���������Ԫ��
            System.out.println(str);
        }
        System.out.println(sList.size());//Ϊ3

        System.out.println("- - - - - - - - - - -");

        int i[]={11,22,33};
        
        List intList=Arrays.asList(i);	//intList�о���һ��Integer�������͵Ķ�������������Ϊһ��Ԫ�ش��ȥ��
        for(Object o:intList){//��һ��Ԫ��
//            System.out.println(o.toString());
            System.out.println(o);
        }
//        List intList1=Arrays.asList(ArrayUtils.toObject(i));	//intList�о���һ��Integer�������͵Ķ�������������Ϊһ��Ԫ�ش��ȥ��
//        for(Object o:intList){//��һ��Ԫ��
//            System.out.println(o.toString());
//        }

//        for (Object a:intList
//             ) {
//            System.out.println((Integer) a);
//        }
        System.out.println("- - - - - - - - - - -");

        Integer ob[]={11,22,33};
        List<Integer> objList=Arrays.asList(ob);	//�������ÿһ��Ԫ�ض�����Ϊlist�е�һ��Ԫ��
        for(int a:objList){
            System.out.println(a);
        }

        System.out.println("- - - - - - - - - - -");

        //objList.remove(0);//asList()���ص���arrays��˽�е��ռ�ArrayList���ͣ�����set,get��contains��������û�����Ӻ�ɾ��Ԫ�صķ��������Դ�С�̶�,�ᱨ��
        //objList.add(0);//����asList���ص�list��ʵ��������add���������Իᱨ��
    }
}
