package bag;

public class Escape {
    public static void main(String[] args) {
        System.out.println(ReturnTest());
        NextTest();
    }
    public static int ReturnTest(){
        int sum=0;
        for(int num=1;num<=10;num++){
            sum=sum+num;
            if(sum>20){
                System.out.println("����ѭ�����ڵķ���");
                return sum=100;//���ã�ֱ�ӽ����ú���������100;
            }
            System.out.println(sum);
        }
        System.out.println("������"+sum);
        return 10;
    }
    public static void NextTest(){
        System.out.println("�ѽ������淽��");
    }
}