package leetcodeproblrms;

import java.util.ArrayList;

class Solution5 {
    public String longestCommonPrefix(String[] strs) {
        int shortestlength=strs[0].length();
        int indexofshortest = 0;
        ArrayList<Character> prefix = new ArrayList<Character>();
        for (int i=0;i< strs.length-1;i++){
            if(shortestlength>strs[i+1].length()){
                shortestlength= strs[i+1].length();
                indexofshortest=i+1;
            }
        }
        if(shortestlength==0){return "";}
        else{
        for (int j=0;j<shortestlength;j++){
            boolean ifprefix = false;
            for (int k =0;k< strs.length;k++) {
                if (strs[indexofshortest].charAt(j) == strs[k].charAt(j)) {
                    ifprefix=true;
                }
                else {ifprefix=false;
                break;}
            }
            if (!ifprefix){break;}
            prefix.add(strs[indexofshortest].charAt(j));
        }
        String wordprefix= "";
        for(char c:prefix){
            wordprefix= wordprefix+ c;
        }
        return wordprefix;}
    }
}

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        Solution5 sc = new Solution5();
        String[] testcase = {"","cbc","c","ca"};

        String answer =sc.longestCommonPrefix(testcase);
        System.out.println(answer);
    }
}
