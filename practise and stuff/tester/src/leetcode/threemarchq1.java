package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class threemarchq1 {
    public static int longestPalindrome(String s, String t) {
        ArrayList<String> ls = new ArrayList<>();
        ArrayList<String> lt = new ArrayList<>();
        ls.add("");
        lt.add("");
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i <s.length() ; i++) {
            for (int j = i+1; j<=s.length() ; j++) {
                String ss = s.substring(i,j);
                ls.add(ss);
            }
        }
        for (int i = 0; i <t.length() ; i++) {
            for (int j = i+1; j<=t.length() ; j++) {
                String ss = t.substring(i,j);
                lt.add(ss);
            }
        }
        int ans =1;
        for (int i = 0; i <lt.size() ; i++) {
            for (int j = 0; j <ls.size() ; j++) {
                StringBuilder rara = new StringBuilder();
                rara.append(ls.get(j));
                rara.append(lt.get(i));
                if(!set.add(rara.toString())){continue;}
                if(ans<rara.length()&&ispalindrome(rara.toString())){
                    ans=Math.max(ans,rara.length());}
            }
        }
        return ans;
    }
    public static boolean ispalindrome(String zaza){
        char[] za =zaza.toCharArray();
        int k = za.length-1;
        for (int i = 0; i <za.length/2 ; i++) {
            if(za[i]!=za[k-i]){return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        longestPalindrome("sahil","balyan");
    }
}
