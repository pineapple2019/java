package dream05;
//一些基本的计算
public class service1 {
    //计算成交金额
    public double Turnover(double share_price,int num){
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
}
