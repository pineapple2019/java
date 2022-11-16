//package ee.ds;
//找的就是你
//public class f {
///*快速排序：
//    1，订一个基准值
//    2，然后进行排序，将左边的比基准值大，右边的比基准值小
//    3，然后不断的递归，直到个区间，只有一个元素为止
// */
//    public static void main(String[] args) {
//        int nums[] = {9,8,7,6,5,4,3,2,1};
////        fastsort(nums);
////      System.out.println();
//        for (int i=0;i< nums.length;i++){
//            System.out.print(nums[i]+",");
//        }
//
//        //每次把基准值归位
//        public static void quicksort(int[] nums,int begin,int end){
//            int key =nums[begin];
//            int i = begin;
//            int j= end;
//            //当i==j时，说明二者已经到了,已经找到了key应该放的位置
//            while(i!=j){
//                while(nums[j]>=key && j>i){
//                    j--;
//                }
//                while(nums[i]<=key && j<i){
//                    i++;
//                }
//                //此时，已经找到两个，一个比其大，一个比其小
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//                //二者进行交换
//                //
//            }
//        }
//        //出了
//        //然后递归的调用
//        nums[begin] = nums[i];
//        nums[i] = key;
//        quicksort(nums,begin,i-1);
//        quicksort(nums,i+1,begin);
//
//    }
//
//}
