package leetcodeproblrms;

import java.util.Arrays;

public class dp33 {
    public static int minDistance(String word1, String word2) {
        if (word1.equals(word2)){return 0;}
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <dp.length ; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <dp[0].length ; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <dp.length; i++) {
            for (int j = 1; j <dp[0].length ; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1 + Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    private static int dista(int[][] dp,String word1, String word2, int i, int j) {
        if (i<0||j<0){
            if (j<0){return i+1;}
            else {return j+1;}
        }
        if (dp[i][j]!=-1){return dp[i][j];}
        if (word1.charAt(i)==word2.charAt(j)){
            dp[i][j]=dista(dp,word1,word2,i-1,j-1);
            return dp[i][j];
        }else{
            int a =1+dista(dp,word1,word2,i-1,j-1);
            int b =1+dista(dp,word1,word2,i,j-1);
            int c =1+dista(dp,word1,word2,i-1,j);
            dp[i][j]=Math.min(a,Math.min(b,c));
            return dp[i][j];
        }
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }
}
