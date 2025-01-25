package leetcodeproblrms;

import java.util.Arrays;

public class dp20 {
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for (int i = 0; i <=amount ; i++) {
            if (i%coins[0]==0){dp[0][i]=i/coins[0];}
            else{dp[0][i]=(int)(1e9);}
        }
        for (int i = 1; i <coins.length; i++) {
            for (int j = 0; j <=amount ; j++) {
                int b = j/coins[i];
                int p = (int)(1e9);
                while (b>=0){
                   p=Math.min(p,b+dp[i-1][j-coins[i]*b]);
                    b--;
                }
                dp[i][j]=p;
            }
        }
        return dp[coins.length-1][amount];

    }

    private static int coin(int[] coins, int amount,int i,int[][] dp) {
        if (amount==0){return 0;}
        if (i==0){
            if(amount%coins[i]==0){dp[i][amount]=amount/coins[i];return dp[i][amount];}
            else {return (int)(1e9);}
        }
        if(amount%coins[i]==0){dp[i][amount]=amount/coins[i];return dp[i][amount];}
        if (dp[i][amount]!=Integer.MAX_VALUE){return dp[i][amount];}

        int p =(int)(1e9);
        int b = amount/coins[i];
        while(b>=0) {
            p = Math.min(p,b + coin(coins, amount - coins[i] * b, i - 1, dp));
            b--;
        }
        dp[i][amount]=p;
        return dp[i][amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5},11));
    }
}
