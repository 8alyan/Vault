package leetcodeproblrms;

import java.util.Arrays;

public class fourfive {
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length-2; i >=0 ; i--) {
            if(i+nums[i]>=nums.length-1){dp[i]=1;}
            else{
                int k = (int)(1e9);
                for (int j = 1; j <=nums[i] ; j++) {
                    k=Math.min(k,dp[i+j]+1);
                }
                dp[i]=k;
            }
        }
        return dp[0];
    }
    public static int helper(int[] dp,int[] nums, int index){
        if (index>=nums.length-1){return 0;}
        if (dp[index]!=-1){return dp[index];}
        int ans =78;
        for (int i = 1; i <=nums[index] ; i++) {
            int z = 1+helper(dp,nums,index+i);
            ans=Math.min(z,ans);
        }
        return dp[index]=ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
