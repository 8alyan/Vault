package leetcodeproblrms;

import java.util.Arrays;

public class fouronesix {
    public static boolean canPartition(int[] nums) {
        int  S=0;
        for (int n: nums){
            S+=n;
        }
        if (S%2==1){return false;}
        boolean[][] dp = new boolean[nums.length+1][S/2+1];
        dp[0][0]=true;
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 0; j <=S/2 ; j++) {
              boolean a = dp[i-1][j];
              boolean b =false;
              if(nums[i-1]<=j){
                  b=dp[i-1][j-nums[i-1]];
              }
              dp[i][j]=a||b;

            }
        }
        return dp[nums.length-1][S/2];
    }

    private static boolean recu(int[] nums, int i, int[][] dp, int s1) {
       if (s1==0&&i==-1){return true;}
       if (i<0){return false;}
       if (i==0&&nums[i]==s1){return true;}
       if (dp[i][s1]!=0){return dp[i][s1]==0;}
       boolean a = recu(nums,i-1,dp,s1);
       boolean b = false;
       if (nums[i]<=s1){
           b=recu(nums,i-1,dp,s1-nums[i]);
       }
       if (a||b){dp[i][s1]=1;}
       else{dp[i][s1]=-1;}
       return a||b;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,11,5,5}));
    }
}
