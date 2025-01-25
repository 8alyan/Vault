package leetcode;

import java.util.*;

public class threefourseven {
    public static int[] topKFrequent(int[] nums, int k) {
            int[] ans = new int[k];
            Map<Integer,Integer> map = new HashMap<>();
            ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];
            for (int i = 0; i < nums.length+1 ; i++) {
                bucket[i]=new ArrayList<>();
            }
            for(int n :nums){
                map.put(n,map.getOrDefault(n,0)+1);
            }
            for (Map.Entry<Integer,Integer> l :map.entrySet()){
                bucket[l.getValue()].add(l.getKey());
            }
            int m =0;
            for (int i = nums.length; i >0 ; i--) {
                for(int n :bucket[i]){
                    ans[m++]=n;
                    if(m==k){return ans;}
                }
            }
            return ans;
    }

    public static void main(String[] args) {
        String[] gh = new String[]{"abc","def","abc"};
        Arrays.sort(gh);
        for (String l :gh ){
            System.out.print(l+" ");
        }
    }
}
