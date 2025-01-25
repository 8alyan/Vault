package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class fivenine {
    static int z =0;
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        helper(ans,0,0,1,1);
        return ans;
    }
    public static void helper(int[][] ans ,int i ,int j,int d,int k){
        if(i<0||i>=ans.length||j<0||j>=ans.length||ans[i][j]!=0){return;}
        while(z!=ans.length*ans.length){
            ans[i][j]=k;
            z++;
            if(d==1){
                if(z== ans.length* ans.length){return;}
                helper(ans,i,j+1,d,k+1);
                d=2;
            }if(d==2){
                if(z== ans.length* ans.length){return;}
                helper(ans,i+1,j,d,k+1);
                d=3;
            }if(d==3){
                if(z== ans.length* ans.length){return;}
                helper(ans,i,j-1,d,k+1);
                d=4;
            }if(d==4){
                if(z== ans.length* ans.length){return;}
                helper(ans,i-1,j,d,k+1);
                d=1;
            }
        }
        ans[i][j]=k;
    }
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> mp = new HashMap<>();
        int[]  tb = new int[128];
        int[] kb = new int[128];
        Arrays.fill(tb,-1);
        Arrays.fill(kb,-1);
        for (int i = 0; i < s.length(); i++) {
            if (tb[s.charAt(i)]==-1&&kb[t.charAt(i)]==-1){
                tb[s.charAt(i)]=t.charAt(i);
                kb[t.charAt(i)]=s.charAt(i);
            }else{
                if(!(tb[s.charAt(i)]==t.charAt(i)&&kb[t.charAt(i)]==s.charAt(i))){return false;}
            }
        }
        return true;
    }

    public static void main(String[] args) {
        generateMatrix(1);
    }
}
