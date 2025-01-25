package leetcodeproblrms;

import java.util.Arrays;

public class oneeighteight {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][2][k+1];
        for (int ind = prices.length-1; ind >=0 ; ind--) {
            for (int buy = 0; buy <=1 ; buy++) {
                for (int l = 1; l <=k ; l++) {
                    int profit=0;
                    if (buy==1){
                        int a = dp[ind+1][0][k]-prices[ind];
                        int b = dp[ind+1][1][k];
                        profit=Math.max(a,b);
                    }
                    else{
                        int a = prices[ind]+dp[ind+1][1][k-1];
                        int b = dp[ind+1][0][k];
                        profit=Math.max(a,b);
                    }
                    dp[ind][buy][k]=profit;
                }
            }
        }
        return dp[0][1][k];
    }
    public int helper(int[][][] dp,int[] prices , int ind ,int buy,int k){
        if (ind==prices.length){return 0;}
        if(k==0){return 0;}
        if (dp[ind][buy][k]!=-1){return dp[ind][buy][k];}
        int profit =0;
        if (buy==1){
            int a = helper(dp,prices,ind+1,0,k)-prices[ind];
            int b = helper(dp,prices,ind+1,buy,k);
            profit=Math.max(a,b);
        }
        else{
            int a = prices[ind]+helper(dp,prices,ind+1,1,k-1);
            int b = helper(dp,prices,ind+1,buy,k);
            profit=Math.max(a,b);
        }
        return dp[ind][buy][k]=profit;
    }
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][5];
        for (int ind = prices.length-1; ind >=0 ; ind--) {
            for (int buy = 0; buy<4; buy++) {
                int profit =0;
                if (buy%2==0){
                    int a = dp[ind+1][buy+1]-prices[ind];
                    int b = dp[ind+1][buy];
                    profit=Math.max(a,b);
                }
                else{
                    int a = prices[ind]+dp[ind+1][buy+1];
                    int b = dp[ind+1][buy];
                    profit=Math.max(a,b);
                }
                dp[ind][buy]=profit;
            }
        }
        return dp[0][0];//zero ale teh devange at zero txn so
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,2,1}));
    }
}
