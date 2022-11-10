package dream0519.dream4;

import java.text.DecimalFormat;

class secretary04{
    //����
    //����
    static double COMMISSION_RATE =  0.0013;   //Ӷ�����0.13%;
    static double STAMP_TAX_RATE = 0.001;      //ӡ��˰��0.1%
    static double TRANSFER_RATE = 0.00001;     //����˰��0.001%

    static double buying_turnover = 0;          //����ɽ����
    static double selling_turnover = 0;         //�����ɽ����

    static double buying_service_charge=0;      //����������
    static double selling_service_charge=0;     //����������

    static double buying_transfer_tax =0;      //�������˰
    static double selling_transfer_tax =0;     //��������˰

    static double stamp_tax =0;    //ӡ��˰

    static double buying_sum = 0;      //һ���ķ������
    static double selling_sum = 0;     //һ���ķ������
    static double profit = 0;          //�˴β���ӯ��

    //����ɽ����
    private double Turnover(double share_price,int num){
        return share_price * num;
    }

    //����������=�ɽ��۸�*����
    private double Service_charge(double turnover,double rate){
       double tax = turnover * rate;
        if (tax<5){
            tax = 5.00;
        }
        return tax;
    }

    //�������˰
    private double Transfer_tax(double turnover,double rate){
        double tax = turnover * rate;
        return tax;
    }

    //����ӡ��˰
    //��������ӡ��˰=�ɽ����*˰��
    private double Stamp_tax(double turnover,double rate){
        double tax = turnover * rate;
        return tax;
    }

    //���뷢����� = �ɽ����+������+����˰
    private double Buy_amount(double turnover,double service_charge,double transfer_tax){
        double sum = turnover + service_charge + transfer_tax;
        return sum;
    }

    //����������� = �ɽ����-������-ӡ��˰-����˰
    private double Sell_amount(double turnover,double service_charge,double transfer_tax,double stamp_tax){
        double sum = turnover - service_charge - stamp_tax - transfer_tax;
        return sum;
    }

    //ӯ��
    private double Profit(double selling_price,double buying_price){
        double sum = selling_price - buying_price;
        return sum;
    }


      public void calculator4(double buying_price,double selling_price,int num){   //����
//    public void calculator4(double buying_price,double selling_price,int num,boolean isBuy){   //����

        /**
         * ����˰��
         */
        buying_turnover = Turnover(buying_price,num);    //����ɽ����
        selling_turnover = Turnover(selling_price,num);   //�����ɽ����

        buying_service_charge = Service_charge(buying_turnover, COMMISSION_RATE); //����������Ӷ��
        selling_service_charge = Service_charge(selling_turnover, COMMISSION_RATE); //����������Ӷ��

        buying_transfer_tax =Transfer_tax(buying_turnover, TRANSFER_RATE);   //�������˰
        selling_transfer_tax =Transfer_tax(selling_turnover, TRANSFER_RATE); //��������˰

        stamp_tax = Stamp_tax(selling_turnover, STAMP_TAX_RATE);   //��������ӡ��˰

        DecimalFormat df = new DecimalFormat("0.00");

        buying_sum = Buy_amount(buying_turnover,buying_service_charge,buying_transfer_tax); //���뷢�����
        selling_sum = Sell_amount(selling_turnover,selling_service_charge,selling_transfer_tax,stamp_tax);  //�����������

        profit = Profit(selling_sum,buying_sum);

System.out.println("����ɽ���"+df.format(buying_turnover)+"\t�����ѣ�"+df.format(buying_service_charge)+"\t����˰��"+df.format(buying_transfer_tax)
        +"\t���뷢����-"+df.format(buying_sum));
System.out.println("�����ɽ���"+df.format(selling_turnover)+"\t�����ѣ�"+df.format(selling_service_charge)+"\t����˰��"+df.format(selling_transfer_tax)+
                "\tӡ��˰��"+df.format(stamp_tax)+"\t����������"+df.format(selling_sum));
//    System.out.println("�˴�ӯ����"+selling_sum);
    System.out.println("�˴�ӯ����"+df.format(profit));
    }
}
//ʵ�ַ��ؽ����

public class dream04 {
    public static void main(String[] args) {
        secretary04 lisa =  new secretary04();
        lisa.calculator4(42.5,43.2,400);

    }
}





