package leetcodeproblrms;

import java.util.Arrays;

public class dp31 {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 1; i <=str1.length() ; i++) {
            for (int j = 1; j <=str2.length() ; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = str1.length();
        int j = str2.length();
        int ind = dp[i][j]-1;
        while(i>0&&j>0){
            if (str1.charAt(i-1)==str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
                ind--;
            }else{
                if (dp[i-1][j]>dp[i][j-1]){
                    ans.append(str1.charAt(i-1));
                    i--;
                }else{
                    ans.append(str2.charAt(j-1));
                    j--;
                }
            }
        }
        while(i>0){
            ans.append(str1.charAt(i-1));
            i--;
        }
        while (j>0){
            ans.append(str2.charAt(j-1));
            j--;
        }
        return ans.reverse().toString();
    }

    private static String locs(int[][] dp, int i, int j,String s,String t) {
        if (i==0||j==0){
            if (i==0&&j==0){return "";}
            else if (i==0){return ""+t.charAt(j-1);}
        else{return ""+s.charAt(i-1);}}
        if(s.charAt(i-1)==t.charAt(j-1)){
            return locs(dp,i-1,j-1,s,t)+s.charAt(i);
        }else{
            if (dp[i][j]==dp[i-1][j]){return locs(dp,i-1,j,s,t)+s.charAt(i-1);}
            else {return locs(dp,i,j-1,s,t)+t.charAt(j-1);}
        }
    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("bcacaaab","bbabaccc"));

    }
}
