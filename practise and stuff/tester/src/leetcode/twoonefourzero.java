package leetcode;

import java.util.Arrays;

public class twoonefourzero {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        for(int i =questions.length-1;i>=0;i--){
            int c = questions[i][0];
            int d = questions[i][1];
            long a =i+d>=questions.length?c:c+dp[i+d+1];
            long b =i+1>=questions.length?0:dp[i+1];
            dp[i]=Math.max(a, b);
        }
        return dp[0];

    }

    public long helper(int[][] questions, int ans, int i,long[] dp) {
        if (i >= questions.length) {
            return ans;
        }
        if(dp[i]!=-1){return dp[i];}
        long a = helper(questions, ans, i+questions[i][1]+1,dp)+ questions[i][0];
        long b = helper(questions, ans, i + 1,dp);
        return dp[i]=Math.max(a, b);
    }

    public static void main(String[] args) {
        twoonefourzero s = new twoonefourzero();
        System.out.println(s.mostPoints(new int[][]{{12,46},{78,19},{63,15},{79,62},{13,10}}));
    }
}
