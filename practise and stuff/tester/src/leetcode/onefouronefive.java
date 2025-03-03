package leetcode;

import java.util.*;

public class onefouronefive {
    public String getHappyString(int n, int k) {
        ArrayList<String> ans = new ArrayList<>();
        helper(-1,new StringBuilder(),n,ans);
        System.out.println(ans);
        if(ans.size()<k){return "";}
        return ans.get(k-1);
    }
    public void helper(int p, StringBuilder po, int n, ArrayList<String> ans){
        if(po.length()==n){
            ans.add(po.toString());return;
        }

            for (int j =0; j <3 ; j++) {
                if(j==p){continue;}
                char r = (char)('a'+j);
                po.append(r);
                helper(j,po,n,ans);
                po.deleteCharAt(po.length()-1);

            }

    }

    public static void main(String[] args) {
        onefouronefive s = new onefouronefive();
        s.getHappyString(3,9);
    }
}
