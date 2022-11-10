package dream0519.dream123;

import dream05.DataObject;
import dream05.Datarate;
import dream05.service1;

public class Test {

    DataObject dataObject = new DataObject();
    Datarate datarate = new Datarate();
    service1 service = new service1();

    public void getee(int num,double price,boolean buy){
        if (buy==true){
            System.out.println("ÂòÈë:"+service.Turnover(price,num));
        }
        if (buy==false){
            System.out.println("Âô³ö:"+service.Turnover(price,num));
        }
    }

    public static void main(String[] args) {
       Test test = new Test();
       test.getee(100,12.4,false);
       test.getee(100,12.1,true);
    }
}
