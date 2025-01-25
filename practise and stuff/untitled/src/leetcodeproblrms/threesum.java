package leetcodeproblrms;

import java.util.*;

public class threesum {
    public static int longestConsecutive(int[] nums) {
       HashSet<Integer> s = new HashSet<>();
       Map<Integer,Integer> map = new HashMap<>();
       for (int n:nums){
           s.add(n);
       }
       int z =0;
       for(int n :s){
           int ans =1;
           int  t =n;
           if (map.containsKey(n-1)){
               z=Math.max(z,map.get(n-1)+1);
               map.put(n,map.get(n-1)+1);
               continue;
           }
           while(s.contains(t-1)){
               if (map.containsKey(t-1)){ans+=map.get(t-1)+1;}
               ans++;
               t=t-1;
           }
           map.put(n,ans);
           z=Math.max(z,ans);
       }
       return z;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
       HashMap<Integer,Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            set.put(nums[i],i);
        }
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
               int z=set.getOrDefault(-1*(nums[i]+nums[j]),-1);
                if (z==-1){continue;}
                if (z>i&&z>j){
                    List<Integer> a = new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[j]);
                    a.add(-1*(nums[i]+nums[j]));
                    ans.add(a);
                }
            }
        }
        return ans.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
