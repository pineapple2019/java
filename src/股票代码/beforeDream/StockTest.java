package beforeDream;

import java.util.Random;

public class StockTest {
    public static void main(String[] args) {

        /*
         *
         * ���������Random�ഴ��һ������������Ķ���,����0��100�����Int�� ����
         * ����import java.util.Random;���������package����������������룩
         * Random random=new Random();
         * random.nextInt(100);
         * Ȼ���random.nextInt(100)���뵽����63��
         * ���ǵ�ǰ�۵ĸ�ֵλ�þͿ��Բ������0��100�ĵ�ǰ����
         */

        Random random=new Random();
        random.nextInt(100);
        //���ﴴ����һ��Stock������Ϊ��stock����������Stock�Ĺ����вη���
        //Ϊÿ�������ֱ�ֵ
        Stock stock = new Stock("SUNW", "Sun",50,random.nextInt(100));
        System.out.println("�۸񸡶���" +stock.toString());

    }
}

