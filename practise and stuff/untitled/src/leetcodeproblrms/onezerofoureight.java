package leetcodeproblrms;

import java.util.*;

public class onezerofoureight {
    public static int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(o->o.length()));
        int[] dp = new int[words.length];
        Arrays.fill(dp,1);
        int maxi=1;
        for(int i =0;i<words.length;i++){
            for(int j =0;j<i;j++){
                if(i==12&&j==10){
                    System.out.println("hello");
                }
                if(chekkar(words[i],words[j])&&dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;

                    maxi=Math.max(dp[i],maxi);
                }
            }
        }
        return maxi;
    }
    public static boolean chekkar(String a ,String b){
        if(a.length()<=b.length()){return false;}
        boolean ek =false;
        int j =0;
        for(int i =0;i<a.length();i++){
            if(j==b.length()){return (!ek&&i==a.length()-1);}
            if(a.charAt(i)!=b.charAt(j)){
                if(ek){return false;}
                else{ek =true;}
            }else{j++;}
        }
        return (ek&&j==b.length());}

    public static void main(String[] args) {
        String[] ar = {"c", "ddcdcebeb", "baece", "ebcafafcdeac", "cefbedd", "ecaeaafdfffaed", "cbfcfabebbbeda", "ce", "acecfaec", "ebeeecdaedcebc", "bba", "fcdaafbbaa", "efdfecebbfed", "cddfffcace", "de", "cbbafcafbcb", "daabfb", "e", "eefaaafbeea", "acaaeab", "fad", "fafa", "deacabafc", "dbaeda", "afdbccfdeb", "fbafbbcecaed", "badfdeecfcd", "fcbefadfacfaec", "bdc", "cfcefebfcd", "dfaaebfcbbbf", "dffedadf", "dffabdacfb", "edeeaadc", "dadbe", "afbadfdcaba", "afeeabaefbcc", "baddfaacdacb", "effcabcaaab", "cecceaffefd", "fdfdcebbdeca", "bcc", "cfacea", "c", "bec", "debcad", "bacbefacdccd", "ae", "dccadafd", "accffbb"};
        System.out.println(longestStrChain(ar));
    }
}
