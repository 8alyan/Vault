package leetcodeproblrms;

import java.util.Arrays;

public class dp17 {
    public  static int numSubseq(int[] nums, int target) {
        int[][] dp = new int[nums.length][target+1];
        for(int[] m: dp){Arrays.fill(m,-1);}
        return zam(nums,target,dp,nums.length-1);
//        for (int i = 0; i <nums.length ; i++) {
//            dp[i][0]=1;
//        }
//
//
//        if (target>=nums[0]){
//            if (nums[0]==0){dp[0][0]=2;}
//            else{dp[0][nums[0]]=1;}}
//        for (int i = 1; i <dp.length ; i++) {
//            for (int j = 0; j <=target ; j++) {
//                int np = dp[i-1][j]%((int)(1e9+7));
//                int p =j>=nums[i]?dp[i-1][j-nums[i]]%((int)(1e9+7)):0;
//                dp[i][j]=(np+p)%((int)(1e9+7));
//            }
//        }
//        return dp[nums.length-1][target];
    }

    private  static int zam(int[] nums, int target, int[][] dp, int i) {
        if (i==0){
            if (nums[0]==target){
            if (nums[0]==0)return 2;
            else {return 1;}}
        else { if (target==0){return 1;}else return 0;}}
        if (target==0){return 1;}
        if (dp[i][target]!=-1){return dp[i][target];}
        int np=zam(nums,target, dp, i-1);
        int p = 0;
        if (target>=nums[i]){
          p= zam(nums,target-nums[i], dp, i-1);
        }
        dp[i][target]=np+p;

        return np+p;
    }

    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{1,1,1},2));
    }
}
