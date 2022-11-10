//package cxds01;
//
//import java.util.Scanner;
//
///**
// * 输入：nums = [-4,-1,0,3,10]
// * 输入一个数组
// * 输出：[0,1,9,16,100]
// * 输出一个数组，以逗号隔开
// */
//public class Solution {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] nums =
//    }
//    public int[] sortedSquares(int[] nums) {
//        int n = nums.length;
//        //因为
//        int k=n-1;
//        int[] res = new int[n];
//        //如果i<j的话，那么当i=j时，就会自动退出循环了，i=j的元素也要放到res数组中
//        //for循环，万能循环
//        for(int i=0,j=n-1;i<=j;){
//            if(nums[i]*nums[i]<nums[j]*nums[j]){
//                res[k--] = nums[j]*nums[j];
//                j--;
//            }else{
//                res[k--] = nums[i]*nums[i];
//                i++;
//            }
//        }
//        return res;
//    }
//
//}
