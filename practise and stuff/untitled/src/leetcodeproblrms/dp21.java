package leetcodeproblrms;

import java.util.Arrays;

public class dp21 {
    public static int findTargetSumWays(int[] nums, int target) {
        int s =0;
        for (int m :nums){s+=m;}
        int x= s-target;
        if (x<0||x%2==1){return 0;}
        int[][] dp = new int[nums.length][x/2+1];
        for (int i = 0; i < nums.length ; i++) {
            dp[i][0]=1;
        }
        if (nums[0]<=target){dp[0][nums[0]]++;}
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 0; j <=x/2; j++) {
                int np = dp[i-1][j];
                int p =0;
                if (j>=nums[i]){
                    p=dp[i-1][j-nums[i]];
                }
                dp[i][j]=np+p;
            }
        }
        return dp[nums.length-1][x/2];
//        for (int[] m : dp){
//            Arrays.fill(m,-1);
//        }
//        return tar(nums,target,nums.length-1,dp,S,0);
    }

    private static int tar(int[] nums, int target, int i,int[][] dp,int s,int p) {
        if (i==0){
            if (p-nums[0]==target||p+nums[0]==target){return 1;}
            else{return 0;}
            }
        if (dp[i][s+p]!=-1){return dp[i][s+p];}
        int a = tar(nums,target,i-1,dp,s,p-nums[i]);
        int b =  tar(nums,target,i-1,dp,s,p+nums[i]);
        dp[i][s+p]=a+b;
        return a+b;
        }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
    }

