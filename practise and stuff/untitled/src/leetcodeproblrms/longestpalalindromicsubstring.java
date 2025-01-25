package leetcodeproblrms;

import java.util.ArrayList;

class solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String ans = "";
        int length = 0;
        char c1;
        if (s.length()<=1){return s;}
        if(s.length()==2&&s.charAt(0)!=s.charAt(1)){return String.valueOf(s.charAt(0));}
        for (int i =0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                      String s1 = s.substring(i,j+1);
                      String s2="";
                  for (int k=0; k<s1.length(); k++)
                   { c1= s1.charAt(k);
                      s2= c1 + s2; }
                    if (s1.equals(s2)&&s1.length()>length){
                          length=s1.length();
                           ans =s1;
                      }
                }
            }
        return ans;}}

public class longestpalalindromicsubstring {
    public static void main(String[] args) {
        ArrayList<Integer>[] ans = new ArrayList[7];
        solution s = new solution();
        System.out.println(s.longestPalindrome("saf"));
//        String asbjhnk = "cdqdbbd";
//        StringBuilder test = new StringBuilder(asbjhnk);
//        System.out.println(test);
//        System.out.println(test.reverse());
//        System.out.println(test==test.reverse());
    }
}
