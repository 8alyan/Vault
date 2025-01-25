package leetcode;

import javax.swing.tree.TreeNode;
import java.util.*;

public class twooneeighttwo {
    public static String repeatLimitedString(String s, int r) {
        int[] tb = new int[26];
        for(char l :s.toCharArray()){
            tb[l-'a']++;
        }
        StringBuilder ans = new StringBuilder();
        boolean flag =false;
        while(ans.length()!=s.length()){
            for(int i = 25;i>=0;i--){
                if(tb[i]==0){continue;}
                if(flag){
                    char p =ans.charAt(ans.length()-1);
                    if(p==(char)('a'+i)){return ans.toString();}
                    ans.append((char)('a'+i));
                    tb[i]--;
                    flag =false;
                    break;
                }
                if(tb[i]<=r){
                    while(tb[i]!=0){
                        ans.append((char)('a'+i));
                        tb[i]--;
                    }
                }else{
                    flag=true;
                    for(int j =0;j<r;j++){
                        ans.append((char)('a'+i));
                        tb[i]--;
                    }
                }
            }
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        int r =5;
        int k =Math.ceilDiv(r,2);
        System.out.println(k);
    }
}
