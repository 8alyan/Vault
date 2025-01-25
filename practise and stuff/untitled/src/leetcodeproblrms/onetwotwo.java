package leetcodeproblrms;

import java.util.Arrays;

public class onetwotwo {
    public int maxProfit(int[] prices) {
        int a =0;
        int b =0;
        int c =0;
        int d =0;
        for (int ind = prices.length-1; ind >=0 ; ind--) {
            for (int buy = 0; buy<2; buy++) {
                int profit =0;
                if (buy==1){
                    a=Math.max(d-prices[ind],c);
                }
                else{
                    b=Math.max(prices[ind]+c,d);
                }
            }
            c=a;
            d=b;
        }
        return a;
    }
    public int helper(int[][] dp,int[] prices , int ind ,int buy,int k){
        if (ind==prices.length){return 0;}
        if(k==0){return 0;}
        if (dp[ind][buy]!=-1){return dp[ind][buy];}
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
        return dp[ind][buy]=profit;
    }
}
