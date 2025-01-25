package leetcode;

import java.util.HashSet;
import java.util.Set;

public class onetwoeight {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n:nums){s.add(n);}
        int ans =0;
        for(int i:s){
            if(!s.contains(i-1)){
                int a =1;
                while(s.contains(i+a)){
                    a++;
                }
                ans=Math.max(ans,a);
            }
        }
        return ans;
    }
}
