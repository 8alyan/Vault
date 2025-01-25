package leetcodeproblrms;

import java.util.Arrays;

public class dp25 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 1; j <dp[0].length ; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        for (int[] m : dp){
            Arrays.fill(m,-1);
        }
        return common(text1,text2,text1.length()-1,text2.length()-1,dp);
    }

    private int common(String text1, String text2, int i, int j, int[][] dp) {
        if (i<0||j<0){return 0;}
        if (dp[i][j]!=-1){return dp[i][j];}
        if (text1.charAt(i)==text2.charAt(j)){
            dp[i][j]=1+common(text1,text2,i-1,j-1, dp);
            return dp[i][j];
        }
        dp[i][j]=Math.max(common(text1,text2,i-1,j, dp),common(text1,text2,i,j-1, dp));
        return dp[i][j];
    }
}
