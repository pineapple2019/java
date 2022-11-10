package dream0519.dream4;

import java.text.DecimalFormat;

class secretary04{
    //服务
    //费率
    static double COMMISSION_RATE =  0.0013;   //佣金费率0.13%;
    static double STAMP_TAX_RATE = 0.001;      //印花税率0.1%
    static double TRANSFER_RATE = 0.00001;     //过户税率0.001%

    static double buying_turnover = 0;          //买入成交金额
    static double selling_turnover = 0;         //卖出成交金额

    static double buying_service_charge=0;      //买入手续费
    static double selling_service_charge=0;     //卖出手续费

    static double buying_transfer_tax =0;      //买入过户税
    static double selling_transfer_tax =0;     //卖出过户税

    static double stamp_tax =0;    //印花税

    static double buying_sum = 0;      //一共的发生金额
    static double selling_sum = 0;     //一共的发生金额
    static double profit = 0;          //此次操作盈利

    //计算成交金额
    private double Turnover(double share_price,int num){
        return share_price * num;
    }

    //计算手续费=成交价格*费率
    private double Service_charge(double turnover,double rate){
       double tax = turnover * rate;
        if (tax<5){
            tax = 5.00;
        }
        return tax;
    }

    //计算过户税
    private double Transfer_tax(double turnover,double rate){
        double tax = turnover * rate;
        return tax;
    }

    //计算印花税
    //（卖方）印花税=成交金额*税率
    private double Stamp_tax(double turnover,double rate){
        double tax = turnover * rate;
        return tax;
    }

    //买入发生金额 = 成交金额+手续费+过户税
    private double Buy_amount(double turnover,double service_charge,double transfer_tax){
        double sum = turnover + service_charge + transfer_tax;
        return sum;
    }

    //卖出发生金额 = 成交金额-手续费-印花税-过户税
    private double Sell_amount(double turnover,double service_charge,double transfer_tax,double stamp_tax){
        double sum = turnover - service_charge - stamp_tax - transfer_tax;
        return sum;
    }

    //盈利
    private double Profit(double selling_price,double buying_price){
        double sum = selling_price - buying_price;
        return sum;
    }


      public void calculator4(double buying_price,double selling_price,int num){   //能力
//    public void calculator4(double buying_price,double selling_price,int num,boolean isBuy){   //能力

        /**
         * 计算税率
         */
        buying_turnover = Turnover(buying_price,num);    //买入成交金额
        selling_turnover = Turnover(selling_price,num);   //卖出成交金额

        buying_service_charge = Service_charge(buying_turnover, COMMISSION_RATE); //买入手续费佣金
        selling_service_charge = Service_charge(selling_turnover, COMMISSION_RATE); //卖出手续费佣金

        buying_transfer_tax =Transfer_tax(buying_turnover, TRANSFER_RATE);   //买入过户税
        selling_transfer_tax =Transfer_tax(selling_turnover, TRANSFER_RATE); //卖出过户税

        stamp_tax = Stamp_tax(selling_turnover, STAMP_TAX_RATE);   //（卖方）印花税

        DecimalFormat df = new DecimalFormat("0.00");

        buying_sum = Buy_amount(buying_turnover,buying_service_charge,buying_transfer_tax); //买入发生金额
        selling_sum = Sell_amount(selling_turnover,selling_service_charge,selling_transfer_tax,stamp_tax);  //卖出发生金额

        profit = Profit(selling_sum,buying_sum);

System.out.println("买入成交金额："+df.format(buying_turnover)+"\t手续费："+df.format(buying_service_charge)+"\t过户税："+df.format(buying_transfer_tax)
        +"\t买入发生金额：-"+df.format(buying_sum));
System.out.println("卖出成交金额："+df.format(selling_turnover)+"\t手续费："+df.format(selling_service_charge)+"\t过户税："+df.format(selling_transfer_tax)+
                "\t印花税："+df.format(stamp_tax)+"\t卖出发生金额："+df.format(selling_sum));
//    System.out.println("此次盈利："+selling_sum);
    System.out.println("此次盈利："+df.format(profit));
    }
}
//实现返回结果，

public class dream04 {
    public static void main(String[] args) {
        secretary04 lisa =  new secretary04();
        lisa.calculator4(42.5,43.2,400);

    }
}





