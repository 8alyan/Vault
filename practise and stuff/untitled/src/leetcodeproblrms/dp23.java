package leetcodeproblrms;

import java.util.Arrays;

public class dp23 {
    static int knapSack(int N, int W, int val[], int wt[]) {
        int[][] dp = new int[N][W+1];
        for (int i = 0; i <=W ; i++) {
            if (i / wt[0] > 0) {
                dp[0][i]=val[0]*(i/wt[0]);
            }
        }
        for (int i = 1; i <N ; i++) {
            for (int j = 0; j<=W ; j++) {
                int np = dp[i-1][j];
                int p= wt[i]<=j?val[i]+dp[i][j-wt[i]]:0;
                dp[i][j]=Math.max(np,p);
            }
        }
        return dp[N-1][W];
//        for (int[] m :dp){
//            Arrays.fill(m,-1);
//        }
//        return sack(val,wt,W,N-1,dp);
    }

    private static int sack(int[] val, int[] wt, int w, int i, int[][] dp) {
        if (i==0){
            if (w/wt[i]>0){return val[0]*(w/wt[i]);}
            else return 0;
        }
        if (dp[i][w]!=-1){return dp[i][w];}
        int np = sack(val,wt,w,i-1, dp);
        int p =wt[i]<=w?val[i]+sack(val,wt,w-wt[i],i, dp):0;
        dp[i][w]=Math.max(np,p);
        return Math.max(np,p);
    }

    public static void main(String[] args) {
        System.out.println(knapSack(2,3,new int[]{1,1},new int[]{2,1}));
    }
}
