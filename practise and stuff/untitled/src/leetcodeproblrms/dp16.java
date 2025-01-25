package leetcodeproblrms;

import java.util.Arrays;

public class dp16 {
    public static int minSubsetSumDifference(int []arr, int n) {
        int S =0;
        for(int i :arr){S+=i;}
        boolean[][] dp = new boolean[arr.length][S+1];
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <=S ; j++) {
                if (i==0&&j==0){dp[i][j]=true;continue;}
                if(i==0&&arr[i]==j){dp[i][j]=true;continue;}
                boolean a =i>0?dp[i-1][j]:false;
                boolean b = false;
                if (i>0&&j>=arr[i]){
                    b= dp[i-1][j-arr[i]];
                }
                dp[i][j]=a||b;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <=S ; i++) {
            if (dp[n-1][i]){
                ans=Math.min(ans,Math.abs(S-2*i));
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(minSubsetSumDifference(new int[]{1,2,3,4},4));
    }
}
