package leetcodeproblrms;

import java.util.Arrays;

public class dp24 {
    public int cutRod(int price[], int n) {
        int[][] dp = new int[n][n+1];
        for (int i = 0; i <=n ; i++) {
            dp[0][i]=price[0]*i;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <=n ; j++) {
                int np = dp[i-1][j];
                int p =j>=i+1?price[i]+dp[i][j-(i+1)]:Integer.MIN_VALUE;
                dp[i][j]=Math.max(np,p);
            }
        }
        System.out.println(dp[n-1][n]);
        for(int[] m:dp){
            Arrays.fill(m,-1);
        }
            return rod(price,n,price.length-1,dp);
    }

    private int rod(int[] price, int n, int i, int[][] dp) {
        if (i==0){
            return price[0]*n;
        }
        if (dp[i][n]!=-1){return dp[i][n];}
        int np = rod(price,n,i-1, dp);
        int p=n>i?price[i]+rod(price,n-i-1,i, dp):0;
        dp[i][n]=Math.max(np,p);
        return Math.max(np,p);
    }
}
