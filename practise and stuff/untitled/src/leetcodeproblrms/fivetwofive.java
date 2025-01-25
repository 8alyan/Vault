package leetcodeproblrms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class fivetwofive {
    public int findMaxLength(int[] nums) {
        
     Map<Integer,Integer> mp = new HashMap<>();
        int count =0;
        int length =0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==0){count--;}else{count++;}
            if(!mp.containsKey(count)){
            mp.put(count,i);}else {
                length=Math.max(length,i-mp.get(count));
            }
        }
        return length;
    }

    public static void main(String[] args) {
        fivetwofive b = new fivetwofive();
        b.findMaxLength(new int[]{0,1});
    }
}
