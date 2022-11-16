package ee.ds;

public class insertsort {
    public static void main(String[] args) {
        int nums[] = {9,8,7,6,5,4,3,2,1};
        insort(nums);
        for (int i=0;i< nums.length;i++){
            System.out.print(nums[i]+",");
        }
    }

    public static void insort(int nums[]){
        //将无序元素放到有序的排列中
        for (int i =0;i<nums.length-1;i++){
            if (nums[i]>nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = nums[i];
            }
        }
    }
}
