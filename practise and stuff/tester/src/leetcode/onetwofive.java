package leetcode;

public class onetwofive {
    public boolean isPalindrome(String s) {
       s=s.toLowerCase();
       int l =0;
       int r =s.length()-1;
       while(r>l){
           while((l<s.length())&&(s.charAt(l)<'a'||s.charAt(l)>'z')&&(s.charAt(l)<'1'||s.charAt(l)>'9')){
               l++;
           }
           while((r>=0)&&(s.charAt(r)<'a'||s.charAt(r)>'z')&&(s.charAt(r)<'1'||s.charAt(r)>'9')){
               r--;
           }
           if((r>l)&&(s.charAt(l)!=s.charAt(r))){return false;}
       }
       return true;
    }
}
