package leetcode;

import java.util.HashMap;
import java.util.Map;

public class eightseventhree {
    public static int lenLongestFibSubseq(int[] arr) {
        int ans =0;
        Map<Integer,Integer> set = new HashMap<>();
        for(int n :arr){
            set.put(n,1);
        }
        for(int i=0;i<arr.length;i++){
            for(int j =i+1;j<arr.length;j++){
                if(set.containsKey(arr[i]+arr[j])){
                        int max = Math.min(set.get(arr[i]),set.get(arr[j]));
                        ans=Math.max(ans,max+2);
                        set.put(arr[i]+arr[j],max+2);}
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{2,4,5,6,7,8,11,13,14,15,21,22,34}));
    }
}
