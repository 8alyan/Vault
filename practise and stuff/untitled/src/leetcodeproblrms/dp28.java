package leetcodeproblrms;

import java.util.Arrays;

public class dp28 {
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int[] z: dp){
            Arrays.fill(z,-1);
        }
      return  palindromesubseq(dp,s,0,s.length()-1);

    }

    private static int palindromesubseq(int[][] dp,String s, int i, int i1) {
        if (i>i1){return 0;}
        if (i==i1){return 1;}
        if (dp[i][i1]!=-1){return dp[i][i1];}
        if (s.charAt(i)==s.charAt(i1)){
            dp[i][i1]=2+palindromesubseq(dp,s,i+1,i1-1);
            return dp[i][i1];
        }
        dp[i][i1]= Math.max(palindromesubseq(dp,s,i+1,i1),palindromesubseq(dp,s,i,i1-1));
        return dp[i][i1];
    }
}
