package leetcodeproblrms;

public class onetwothree {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        for (int ind = prices.length-1; ind >=0 ; ind--) {
            for (int buy = 0; buy<2; buy++) {
                for (int i = 1; i <=2 ; i++) {
                    int profit =0;
                    if (buy==1){
                        int a = dp[ind+1][0][i]-prices[ind];
                        int b = dp[ind+1][buy][i];
                        profit=Math.max(a,b);
                    }
                    else{
                        int a = prices[ind]+dp[ind+1][1][i-1];
                        int b = dp[ind+1][buy][i];
                        profit=Math.max(a,b);
                    }
                }
        }}
            return dp[0][1][2];
    }
}
