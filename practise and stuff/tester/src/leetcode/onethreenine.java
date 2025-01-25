package leetcode;

import java.util.*;

public class onethreenine {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return help(s,set,0,dp);
    }
    public static boolean help(String s ,Set<String> set,int j,int[] dp){
        if(j==s.length()){return true;}
        if(dp[j]!=-1){return dp[j]==1;}
        for(int i =j;i<s.length();i++){
            String c = s.substring(j,i+1);
            if(set.contains(c)){
                if(help(s,set,i+1,dp)){dp[j]=1;return true;}
            }
        }
        dp[j]=0;
        return false;
    }

    public static void main(String[] args) {
        List<String> j = new ArrayList<>();
        j.add("leet");
        j.add("code");
        System.out.println(wordBreak("leetcode",j));
    }
}
