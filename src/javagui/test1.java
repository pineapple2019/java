package ee.ds;

public class test1 {
    public static void main(String[] args) {

        int[] a = new int[]{1,3,5,7,2,4,6,8}; //4
        quickSort(a,0,7);
           for (int i=0;i<5;i++){
               System.out.println(a[i]);
           }

    }

    public static int[] smallestK(int[] arr, int k) {
        /**
         分析： 找出数组中最小的k个值，然后返回这k个值
         思路1：将数组排序，然后找到k个值
         时间复杂度：为O（n）的
         */
        if(k==0||arr.length==0){
            return new int[0];
        }

        int left = 0;
        int right = arr.length-1;
        quickSort(arr,left,right);
        //这个是O（k）
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = arr[i];
        }
        return res;
    }
    //知道思想，写不出代码。
    //左右快排函数
    public static void quickSort(int array[],int left,int right){
        /**
         这个是将左右划分开
         */
        if(left<right){
            int mid = quickSort2(array,left,right);
            quickSort2(array,left,mid-1);
            quickSort2(array,mid+1,right);
        }
    }

    //一趟快排函数
    public static int quickSort2(int[] array,int left,int right){
        //目的就是让左边的元素都是小于基准值，右边的元素都大于基准值
        int pivot = array[left];
        //先来右边，因为基准值在左边
        while(left<right){
            while(array[right]>=pivot&&left<right){
                right--;    //如果右边的元素大，那么就没问题，很守规矩，可以过
                //就是不用换，等于需要换吗，等于也不需要换
            }
            array[left]=array[right];
            while(array[left]<=pivot&&left<right){
                left++;
            }
            array[right] = array[left];
        }

        array[left] = pivot;
        return left;
    }
}