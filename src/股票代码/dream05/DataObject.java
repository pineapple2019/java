package dream05;

public class DataObject {
    //定义变量
    //将一些简单的函数进行封装
    //重写toString方法，进行将内容表示出来

    static double buying_turnover;          //买入成交金额
    static double selling_turnover;         //卖出成交金额
    int num;                                //买入数量

    static double buying_service_charge;      //买入手续费
    static double selling_service_charge;     //卖出手续费

    static double buying_transfer_tax;      //买入过户税
    static double selling_transfer_tax;     //卖出过户税

    static double stamp_tax;    //本次印花税

    static double buying_sum;      //一共的发生金额
    static double selling_sum0;     //一共的发生金额
    static double profit;          //此次操作盈利

    public DataObject() {
    }

    //买入金额，卖出金额，买入手数。主要作用是用来初始化
    public DataObject(double buying_turnover,double selling_turnover,int num) {
        this.buying_turnover = buying_turnover;
        this.selling_turnover = selling_turnover;
        this.num = num;
    }

    //设置买入金额，可以通过构造函数或者set函数
    public static double setBuying_turnover(double buying_turnover) {
        return buying_turnover = buying_turnover;
    }

    //获取买入金额
    public static double getBuying_turnover() {
        return buying_turnover;
    }
    //获取卖出金额
    public static double getSelling_turnover() {
        return selling_turnover;
    }
    //设置卖出金额
    public static void setSelling_turnover(double selling_turnover) {
        DataObject.selling_turnover = selling_turnover;
    }

    public static double getBuying_service_charge() {
        return buying_service_charge;
    }

    public static double setBuying_service_charge(double buying_service_charge) {
        return buying_service_charge = buying_service_charge;
    }

    public static double getSelling_service_charge() {
        return selling_service_charge;
    }

    public static double setSelling_service_charge(double selling_service_charge) {
        return selling_service_charge = selling_service_charge;
    }

    public static double getBuying_transfer_tax() {
        return buying_transfer_tax;
    }

    public static void setBuying_transfer_tax(double buying_transfer_tax) {
        DataObject.buying_transfer_tax = buying_transfer_tax;
    }

    public static double getSelling_transfer_tax() {
        return selling_transfer_tax;
    }

    public static void setSelling_transfer_tax(double selling_transfer_tax) {
        DataObject.selling_transfer_tax = selling_transfer_tax;
    }

    public static double getStamp_tax() {
        return stamp_tax;
    }

    public static void setStamp_tax(double stamp_tax) {
        DataObject.stamp_tax = stamp_tax;
    }

    public static double getBuying_sum() {
        return buying_sum;
    }

    public static void setBuying_sum(double buying_sum) {
        DataObject.buying_sum = buying_sum;
    }

    public static double getSelling_sum0() {
        return selling_sum0;
    }

    public static void setSelling_sum0(double selling_sum0) {
        DataObject.selling_sum0 = selling_sum0;
    }

    public static double getProfit() {
        return profit;
    }

    public static void setProfit(double profit) {
        DataObject.profit = profit;
    }


    @Override
    public String toString() {
        return super.toString();
    }

}
