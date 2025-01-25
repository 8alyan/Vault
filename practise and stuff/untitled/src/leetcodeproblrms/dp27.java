package leetcodeproblrms;

import java.util.Arrays;

public class dp27 {
    static int a = 0;
    static int  longestCommonSubstr(String S1, String S2, int n, int m){
        int a  =0;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(S1.charAt(i-1)==S2.charAt(j-1)){dp[i][j]=dp[i-1][j-1]+1;a=Math.max(a,dp[i][j]);}
            }
        }
        return a;
    }


    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("ABCDGH","ACDGHR",6,6));

    }
}
