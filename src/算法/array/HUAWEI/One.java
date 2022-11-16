package 算法.array.HUAWEI;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author pineapple
 */
public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //村民数目
        int m = sc.nextInt();
        //村民资产数目
        int[] a = new int[m];
        for(int i=0;i<m;i++){
           a[i] = sc.nextInt();
        }
        //捐款数目
        int n = sc.nextInt();
        sc.close();
        //从小到大，排序村民资产
        Arrays.sort(a);
        //相同资产村民数，剩余捐款数
        int res =1,yu=n;

        for(int i = m-1;i>=0;i--){
//            if(res>m-i){
//                break;
//            }

            int j = i,sum=0;
            //村民数不小于0，分配的资产小于剩余捐款数
            while(j>0&&sum+a[i]-a[j-1]<n){
                sum += (a[i]-a[j-1]);
                j--;
            }
            if(i-j+1>res){
                res = i-j+1;
                yu = n-sum;
            }
            if(i-j+1 == res && yu>n-sum){
                yu = n-sum;
            }
        }

        //输出相同资产村民数，和剩余捐款数
        System.out.println(res+" "+yu);
    }

}


