package dream0519.dream4;

import java.text.DecimalFormat;
/*开发背景：
    当前市面上的软件，具有两个不足点
    1，都不具备能够看到当天进行交易的数据
    2，没有显示每次交易操作的手续费
    3，没有显示每次做t多少，才能够不亏本，以及显示降低了多少成本
故，我由此开发了这个程序！
 */


//开始实现计算！
/*
成交金额 = 当前股价*股数

佣金：成交金额*佣金比例，不足5元，收取5元，买卖均收取
        佣金费率：0.13‰
印花税：成交金额*0.1%,卖方收取，无起点要求
过户税：成交金额*0.001%，买卖均收取，无起点要求


目标：做t一次，需要多少手续费
低买高买，会收取多少手续费

买入手续费：
卖出手续费：
一共手续费：
举例子：
买入：600756
数量：200
成交价格：12.39
成交金额：2478.00
手续费：5.00
印花税：0
过户税：0.02
发生金额：-2483.02
*/

public class dream03 {
    public static void main(String[] args) {

        secretary03 lisa =  new secretary03();
//        lisa.calculator(12.39,200,"buy");
        lisa.calculator(12.39,12.68,200,"sell");


    }
}

class secretary03{   //服务

    //输入：当前股价，交易数量,操作buy、sell
    //输出：成交金额，手续费，发生金额

    //买卖应该封装成两个函数。为什么？
    //因为我们要算最终的结果，然后需要卖-买，知道了，我只需要再添加一个参数就行了

//    //计算盈利
//    //参数，买入数量，买入价格，卖出价格
////    public void calculator1(int num,double buying_price,double selling_price){
////
////
////    }
//
//    public void calculator1(double curprice,int num,String operator){
//
//        if (operator.equals("buy"))
//        {
//            /*应该返回一个信息对象，
//            成交金额
//            手续费
//            印花税
//            过户税
//            发生金额
//            */
//            //这个和点餐还不一样，这个是计算类的
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

    //我不应该在这个上面改的，应该再新建一个的

    //费率
    static double commission_rate =  0.0013;   //佣金费率0.13%;
    static double stamp_tax_rate = 0.001;      //印花税率0.1%
    static double transfer_rate = 0.00001;     //过户税率0.001%
    static double service_charge=0;            //手续费
    static double stamp_tax_rate_result =0;    //印花税
    static double transfer_rate_result =0;     //过户税
    static double sum = 0;                     //一共的发生金额
    static double profit = 0;                  //此次操作盈利

    //返回成交金额
    private double Turnover(double share_price,int num){
        return share_price * num;
    }

    //返回佣金手续费=成交价格*费率
    private double Service_charge(double turnover,double rate){
        service_charge = turnover * rate;
        if (service_charge<5){
            service_charge = 5.00;
        }
        return service_charge;
    }

public void calculator(double buying_price,double selling_price,int num,String operator){   //能力


        double buying_turnover = Turnover(buying_price,num);    //买入成交金额
        double selling_turnover = Turnover(buying_price,num);   //卖出成交金额


        //手续费佣金
        service_charge = Service_charge(buying_turnover,commission_rate);


        //过户税
        transfer_rate_result = buying_turnover * transfer_rate;

        //印花税
        if (operator.equals("sell")){
            stamp_tax_rate_result = buying_turnover * stamp_tax_rate;
        }
        DecimalFormat df = new DecimalFormat("0.00");

        if (operator.equals("buy")) {
            //此次操作如果是买
            //发生金额 = 成交金额+手续费+印花税+过户税
            sum = buying_turnover + service_charge + stamp_tax_rate_result + transfer_rate_result;
        }else{
            //发生金额 = 成交金额-手续费-印花税-过户税
            sum = buying_turnover - service_charge - stamp_tax_rate_result - transfer_rate_result;
        }
//        System.out.println(df.format(new Double("11.015")));

        System.out.println("此次交易的费用如下：");
//        System.out.println(df.format(Turnover));
        System.out.println("成交金额："+df.format(buying_turnover));
        System.out.println("手续费："+df.format(service_charge));
        System.out.println("印花税（如果是买，请忽略）："+df.format(stamp_tax_rate_result));
        System.out.println("过户税："+df.format(transfer_rate_result));
        //如果是买，那么就在前面加一个"-";
        //此时手续费
        System.out.println();
        System.out.println( operator.equals("buy")?"此次发生金额：-"+df.format(sum):"此次发生金额：+"+df.format(sum));

//        profit
    }

    //实现，每次做t，多少钱才不算亏
}
