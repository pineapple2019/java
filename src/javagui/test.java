package ee.ds;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        int[][] a = {{0,0,0},{0,1,0},{0,0,0}};
        int[] a = {0,1,2,4,5,7};
        summaryRanges(a);
    }
    public static List<String> summaryRanges(int[] nums) {
        /**
         题意：将输入的数组切分为连续的几段，然后按照要求的格式写入集合中

         分析：使用双指针，i指向每个区间的起始位置，j从i开始向后遍历，直到不满足
         连续递增（或者j达到数组边界），则当前区间结束；然后将i指向更新为j+1，作为下一个区间的开始位置。
         j继续向后遍历，找下一个区间结束位置，如此循环，直到输入数组遍历完毕。
         复杂问题，具体分析，在纸上画一画就知道了，
         输入：nums = [0,1,2,4,5,7]
         输出：["0->2","4->5","7"]
         */

        List<String> res = new ArrayList<>();
        int n =nums.length;
        int i = 0;
        int j =0;


        while(i<n&&j<n){
            //如果是递增，那么就一直向后加加
            if(nums[j+1] ==nums[j]+1){
                j++;
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                if(i!=j){
                    sb.append("->").append(nums[j]);
                }
                res.add(sb.toString());
                //否则区间结束， 按照格式添加到res中
                //将i指向j+1，j继续向后遍历

                i = j+1;

            }
            j++;
        }
        return res;
    }

}