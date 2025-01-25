package leetcodeproblrms;

import java.util.Arrays;

public class dp53 {
    //sahil
    //lihas
    public static int minCut(String s) {
        int[] dp = new int[s.length()+1];
        for(int i =s.length()-2;i>=0;i--){
            if(pali(s,i,s.length()-1)){dp[i]=0;continue;}
            int ans = s.length();
            for (int k = i+1; k <s.length()-1 ; k++) {
                if(pali(s,i,k)){
                    ans=Math.min(1+dp[k+1],ans);
                }
            }
            dp[i]=ans;
        }
        return dp[0];

    }
    public int idkhoe(int[] dp,String s,int i){
        if(i==s.length()-1){return 0;}
        if(pali(s,i,s.length())){return dp[i]=0;}
        if(dp[i]!=-1){return dp[i];}
        int ans = s.length();
        for (int k = i; k <=s.length() ; k++) {
            if(pali(s,i,k)){
                ans=Math.min(1+idkhoe(dp,s,k+1),ans);
            }
        }
        return dp[i]=ans;
    }
    public static boolean pali(String a,int i ,int j ){
        if(i==j){return true;}
        while(j>i){
            if (a.charAt(i)==a.charAt(j)){i++;j--;}
            else{return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minCut("bb"));
    }
}
