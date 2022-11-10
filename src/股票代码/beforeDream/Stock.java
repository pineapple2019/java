package beforeDream;

//��������������������ļ۸񸡶��˶���

public class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    //�޲����Ĺ��췽��
    Stock(){

    }

    //���룬��Ʊ�����������̼ۣ���ǰ�۸�
    //�����������Ե������Ĺ��췽��
    Stock(String symbol, String name,double previousClosingPrice,double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.currentPrice=currentPrice;
        this.previousClosingPrice=previousClosingPrice;
    }

    //�������Ե�Getters��Setters����
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice=currentPrice;
    }
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice=previousClosingPrice;

    }

    //objectΪ������ĸ��ࣨ�ں���ѧ����������ָ���ǣ���д�����ࣨ����Ϊ��toString���������
    //�ڷ�������д�˵õ��۸�仯��������ʽ
    public String toString() {
        double i=(currentPrice-previousClosingPrice)/previousClosingPrice;
        return "�۸�仯����Ϊ��"+i+"%";

    }
}

