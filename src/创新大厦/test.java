package 创新大厦;
//https://leetcode.cn/problems/smallest-k-lcci/
public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,7,2,4,6,8};
//        int[] a = new int[]{9,7,6,5,4,3,2,1};
        int n = a.length-1;
        quickSort(a,0,n);
        for (int i=0;i<n;i++){
            System.out.println(a[i]);
        }
    }
//快速排序有两种，一种单路快排，一种双路快排，

    public static void quickSort(int array[],int left,int right){
        /**
         这个是将左右划分开
         */
        if(left<right){
            int mid = quickSort3(array,left,right);
//            if(mid-1>=0)
//            {
                quickSort(array,left,mid-1);
//            }
//            if(mid+1< array.length)
//            {
                quickSort(array,mid+1,right);
//            }
        }
    }
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

    /**
     *  双路快排
     *  思路：
     *      1，确定基准值（一般选取第一个元素），定义左右哨兵
     *      2，将基准值元素和两个哨兵进行比较
     *      2.1，两个哨兵开始移动，直到右哨兵元素小于基准值，否则，右哨兵不断向左移动
     *      2.2，左边的哨兵如果小于等于基准值，那么左哨兵不断向右移动，直到左哨兵大于基准值
     *      3，当两个哨兵都不移动时，开始交换两个哨兵所指向的元素
     *      4，只要左哨兵小于右哨兵，那么就不断的重复上述，直到左哨兵不小于右哨兵元素
     *      5, 当左右哨兵相遇时，说明相遇的这个位置，就是pivot这个元素应该待的位置
     */
    public static int quickSort3(int[] array,int left,int right){
        int pivot = array[left];
        while(left<right){
            //先和右边的元素进行比较
            //left<right，避免了初始化，left和pivot重合，然后right=pivot时，right--就越界了
            while(pivot<array[right]&&left<right){
                right--;
            }
            //再和左边的元素进行比较
            while(pivot>array[left]&&left<right){
                left++;
            }

            /**
             * 不满足上述条件，开始交换
             * java的交换函数也是一个小知识点
             * java中只有值传递
             */

            if(left< right)
            {
                            swap(array,left,right);
//                int temp = array[left];
//                array[left] = array[right];
//                array[right] = temp;
            }


        }
        return left; //返回left或者right都一样
    }

    public static void swap(int[] array,int left,int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}




