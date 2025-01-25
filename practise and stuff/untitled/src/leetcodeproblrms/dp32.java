package leetcodeproblrms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class dp32 {
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i <dp.length ; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 1; j <dp[0].length ; j++) {
                int a =0;
                if (s.charAt(i-1)==t.charAt(j-1)){
                    a=dp[i-1][j-1];
                }
                int b = dp[i-1][j];
                dp[i][j]=a+b;
            }
        }
        return dp[s.length()][t.length()];
    }

    private static int num(int[][] dp,String s, String t, int i, int j ) {
        if (i==0||j==0){
            if (j==0){return 1;}
            else {return 0;}
        }
        if (dp[i][j]!=-1){return dp[i][j];}
        int a =0;
        if (s.charAt(i-1)==t.charAt(j-1)){
             a = num(dp, s, t, i-1, j-1);
        }
        int b = num(dp, s, t, i-1, j);
        dp[i][j]=a+b;
        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println( numDistinct("babgbag","bag"));
    }}
