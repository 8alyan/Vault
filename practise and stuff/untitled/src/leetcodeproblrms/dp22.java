package leetcodeproblrms;

import java.util.Arrays;

public class dp22 {
    
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for (int i = 0; i <=amount ; i++) {
            if (amount%coins[0]==0){dp[0][i]=1;}
        }
        for (int i = 1; i <coins.length; i++) {
            for (int j = 0; j <=amount ; j++) {
                int np =dp[i-1][j];
                int p =j>=coins[i]?p=dp[i][j-coins[i]]:0;
                dp[i][j]=np+p;
            }
        }
        return dp[coins.length-1][amount];

    }

    private int changa(int amount, int[] coins, int i,int[][] dp) {
        if (i==0){
            if (amount-coins[0]==0||amount%coins[0]==0||amount==0){return 1;}
            else {return 0;}
        }
        if (dp[i][amount]!=-1){return dp[i][amount];}
        int np = changa(amount,coins,i-1,dp);
        int p =0;
        if (amount>=coins[i]){
            p=changa(amount-coins[i],coins,i,dp);
        }
        dp[i][amount]=np+p;
        return np+p;
    }
}
