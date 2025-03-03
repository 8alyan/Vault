package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class onefivetwo {
    public static int maxProduct(int[] nums) {
        int ans =Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){ans=Math.max(0,ans);continue;}
            int sum =1;
            for(int j =i;j<nums.length;j++){
                sum*=nums[j];
                ans=Math.max(sum,ans);
            }
        }
        return ans;
    }
    public static int maxSum(int[] nums, int m, int k) {
        int sum =0;
        for(int n :nums){sum+=n;}
        int la =0;
        int ans =0;
        for (int i = 0; i <m-1 ; i++) {
            la+=nums[i];
            if(la>0){la=0;}
            else{
                ans=Math.min(ans,la);
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            la+=nums[i];
            if(la>0){la=0;}
            else{
                ans=Math.min(ans,la);
            }
        }
        return sum-ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{1,2,-1,3,3,4},2,2));
    }
}
