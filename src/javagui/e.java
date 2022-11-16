package ee.ds;
//冒泡排序
public class e {
    public static void main(String[] args) {
        int nums[] = {9,8,7,6,5,4,3,2,1};
        bubu(nums);
//        System.out.println();
        for (int i=0;i< nums.length;i++){
            System.out.print(nums[i]+",");
        }
    }

    public static void bubu(int n[]){
        for (int i=0;i<n.length;i++){
            //每次排好一个元素，
            for(int j=0;j<n.length-1;j++){
               if (n[j]>n[j+1]){
                   int temp = n[j];
                   n[j] = n[j+1];
                   n[j+1] = temp;
               }
            }
        }
    }
}
