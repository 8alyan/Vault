package leetcodeproblrms;

import java.util.Arrays;

public class dp34 {
    public static boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int[] d:dp){
            Arrays.fill(d,-1);
        }
       return match(dp,s,p,s.length()-1,p.length()-1);
    }

    private static boolean match(int[][] dp,String s, String p, int i, int j) {
        if (i<0||j<0){
            while(j>=0&&p.charAt(j)=='*'){j--;}
            return i < 0 && j < 0;
        }
        if (dp[i][j]!=-1){return dp[i][j]==1;}
        if (p.charAt(j)=='?'||p.charAt(j)==s.charAt(i)){
             if (match(dp,s,p,i-1,j-1)){dp[i][j]=1;return true;}
             else{dp[i][j]=0;return
             false;}
        }else if (p.charAt(j)=='*'){
            for (int k = 0; k <=i+1 ; k++) {
                if (match(dp,s,p,i-k,j-1)){dp[i][j]=1;return true;}
            }
            
        }
        dp[i][j]=0;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("adceb","*a*b"));
    }
}
