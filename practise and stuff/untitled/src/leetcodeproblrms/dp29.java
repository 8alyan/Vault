package leetcodeproblrms;

import java.util.Arrays;

public class dp29 {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int[] m:dp){
            Arrays.fill(m,-1);
        }
        return s.length()-min(dp,s,0,s.length()-1);
    }

    private int min(int[][] dp,String s, int i, int j) {
        if(i==j){return 1;}
        if (i>j){return 0;}
        if (dp[i][j]!=-1){return dp[i][j];}
        if (s.charAt(i)==s.charAt(j)){
            dp[i][j]= 2+min(dp, s, i+1, j-1);
            return dp[i][j];
        }
        dp[i][j]=Math.max(min(dp, s, i-1, j),min(dp, s, i, j-1));
        return dp[i][j];
    }

    public static void main(String[] args) {
        dp29 d = new dp29();
        System.out.println(d.minInsertions("zzazz"));
    }
}
