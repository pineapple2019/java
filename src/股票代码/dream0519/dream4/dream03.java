package dream0519.dream4;

import java.text.DecimalFormat;
/*����������
    ��ǰ�����ϵ�������������������
    1�������߱��ܹ�����������н��׵�����
    2��û����ʾÿ�ν��ײ�����������
    3��û����ʾÿ����t���٣����ܹ����������Լ���ʾ�����˶��ٳɱ�
�ʣ����ɴ˿������������
 */


//��ʼʵ�ּ��㣡
/*
�ɽ���� = ��ǰ�ɼ�*����

Ӷ�𣺳ɽ����*Ӷ�����������5Ԫ����ȡ5Ԫ����������ȡ
        Ӷ����ʣ�0.13��
ӡ��˰���ɽ����*0.1%,������ȡ�������Ҫ��
����˰���ɽ����*0.001%����������ȡ�������Ҫ��


Ŀ�꣺��tһ�Σ���Ҫ����������
������򣬻���ȡ����������

���������ѣ�
���������ѣ�
һ�������ѣ�
�����ӣ�
���룺600756
������200
�ɽ��۸�12.39
�ɽ���2478.00
�����ѣ�5.00
ӡ��˰��0
����˰��0.02
������-2483.02
*/

public class dream03 {
    public static void main(String[] args) {

        secretary03 lisa =  new secretary03();
//        lisa.calculator(12.39,200,"buy");
        lisa.calculator(12.39,12.68,200,"sell");


    }
}

class secretary03{   //����

    //���룺��ǰ�ɼۣ���������,����buy��sell
    //������ɽ��������ѣ��������

    //����Ӧ�÷�װ������������Ϊʲô��
    //��Ϊ����Ҫ�����յĽ����Ȼ����Ҫ��-��֪���ˣ���ֻ��Ҫ�����һ������������

//    //����ӯ��
//    //��������������������۸������۸�
////    public void calculator1(int num,double buying_price,double selling_price){
////
////
////    }
//
//    public void calculator1(double curprice,int num,String operator){
//
//        if (operator.equals("buy"))
//        {
//            /*Ӧ�÷���һ����Ϣ����
//            �ɽ����
//            ������
//            ӡ��˰
//            ����˰
//            �������
//            */
//            //����͵�ͻ���һ��������Ǽ������
//            operator_buy();
//
//        }
//        if(operator.equals("sell"))
//        {
//            operator_sell();
//        }
//    }
//
//    public void operator_buy(){
//
//    }
//    public void operator_sell(){
//
//    }

    //�Ҳ�Ӧ�����������ĵģ�Ӧ�����½�һ����

    //����
    static double commission_rate =  0.0013;   //Ӷ�����0.13%;
    static double stamp_tax_rate = 0.001;      //ӡ��˰��0.1%
    static double transfer_rate = 0.00001;     //����˰��0.001%
    static double service_charge=0;            //������
    static double stamp_tax_rate_result =0;    //ӡ��˰
    static double transfer_rate_result =0;     //����˰
    static double sum = 0;                     //һ���ķ������
    static double profit = 0;                  //�˴β���ӯ��

    //���سɽ����
    private double Turnover(double share_price,int num){
        return share_price * num;
    }

    //����Ӷ��������=�ɽ��۸�*����
    private double Service_charge(double turnover,double rate){
        service_charge = turnover * rate;
        if (service_charge<5){
            service_charge = 5.00;
        }
        return service_charge;
    }

public void calculator(double buying_price,double selling_price,int num,String operator){   //����


        double buying_turnover = Turnover(buying_price,num);    //����ɽ����
        double selling_turnover = Turnover(buying_price,num);   //�����ɽ����


        //������Ӷ��
        service_charge = Service_charge(buying_turnover,commission_rate);


        //����˰
        transfer_rate_result = buying_turnover * transfer_rate;

        //ӡ��˰
        if (operator.equals("sell")){
            stamp_tax_rate_result = buying_turnover * stamp_tax_rate;
        }
        DecimalFormat df = new DecimalFormat("0.00");

        if (operator.equals("buy")) {
            //�˴β����������
            //������� = �ɽ����+������+ӡ��˰+����˰
            sum = buying_turnover + service_charge + stamp_tax_rate_result + transfer_rate_result;
        }else{
            //������� = �ɽ����-������-ӡ��˰-����˰
            sum = buying_turnover - service_charge - stamp_tax_rate_result - transfer_rate_result;
        }
//        System.out.println(df.format(new Double("11.015")));

        System.out.println("�˴ν��׵ķ������£�");
//        System.out.println(df.format(Turnover));
        System.out.println("�ɽ���"+df.format(buying_turnover));
        System.out.println("�����ѣ�"+df.format(service_charge));
        System.out.println("ӡ��˰�������������ԣ���"+df.format(stamp_tax_rate_result));
        System.out.println("����˰��"+df.format(transfer_rate_result));
        //���������ô����ǰ���һ��"-";
        //��ʱ������
        System.out.println();
        System.out.println( operator.equals("buy")?"�˴η�����-"+df.format(sum):"�˴η�����+"+df.format(sum));

//        profit
    }

    //ʵ�֣�ÿ����t������Ǯ�Ų����
}
