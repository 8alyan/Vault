package leetcodeproblrms;

import java.util.Arrays;

public class dp30 {
    public static int minDistance(String word1, String word2) {
        int[][] dp =  new int[word1.length()][word2.length()];
        for (int[] z:dp){
            Arrays.fill(z,-1);
        }
        int c =dist(dp,word1,word2,word1.length()-1,word2.length()-1);
        int ans = word1.length()+word2.length()-2*c;
        return ans;
    }

    private static int dist(int[][] dp, String word1, String word2, int i, int j) {
        if (i<0||j<0){return 0;}
        if (dp[i][j]!=-1){return dp[i][j];}
        if (word1.charAt(i)==word2.charAt(j)){
            dp[i][j]=1+dist(dp, word1, word2, i-1, j-1);
        }else{
            dp[i][j]=Math.max(dist(dp, word1, word2, i-1, j),dist(dp, word1, word2, i, j-1));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("abcd","anc"));
    }
}
