package leetcode;

import java.util.HashSet;
import java.util.Set;

public class twosixnineeight {
    public static Set<Integer> set = new HashSet<>();
    public int punishmentNumber(int n) {
        int ans =0;
        for(int i =1;i<=n;i++){
            if(set.contains(i)||helper(i)){
                ans+=i*i;
                set.add(i);
            }
        }
        return ans;
    }
    public boolean helper(int i){
     String a = Integer.toString(i*i);
     return helper1(a,i,0);
    }
    public boolean helper1(String a,int i,int j){
        if(i==0&&j==a.length()){return true;}
        if(j>=a.length()){return false;}
        for (int k = j+1; k <=a.length() ; k++) {
            int b = Integer.parseInt(a.substring(j,k));
            if(helper1(a,i-b,k)){return true;}
        }
        return false;
    }

    public static void main(String[] args) {
        twosixnineeight s = new twosixnineeight();
        System.out.println(s.helper(37));
    }
}
