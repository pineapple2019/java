package 算法.array;


import java.util.Scanner;

/**
 * 209. 长度最小的子数组
 * 输入输出：
 * 三行
 * 1，target
 * 2，数组
 * 3，结果
 * @author pineapple
 */
public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] nums = new int[9];
    }

    /**
     * 暴力法
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        int subLength;
        for(int i=0;i<n;i++){
            sum =0;
            for(int j = i;j<n;j++){
                sum += nums[j];
                if(target<=sum){
                    subLength = j-i+1;
                    res = Math.min(res,subLength);
                    break;
                }
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }

    /**
     * 滚动数组
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        int subLength;
        int i=0; //滑动窗口起始位置
        for (int j=0;j<n;j++){
            sum +=nums[j];
            while (sum>=target){
                subLength = j-i+1;
                res = res < subLength?res:subLength;
                sum-=nums[i++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}


