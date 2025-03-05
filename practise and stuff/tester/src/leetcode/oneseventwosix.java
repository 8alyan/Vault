package leetcode;

import java.util.HashMap;
import java.util.Map;

public class oneseventwosix {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        int ans =0;
        for(Map.Entry<Integer,Integer> k : map.entrySet() ){
            int n = k.getValue();
            if(n>=2) {
                ans += n * 4;
            }
        }
        return ans;
    }
    public int helper(int n ){
        if(n<=1){return n;}
        return helper(n-1)*n;
    }

    public static void main(String[] args) {
        int[] zaza = new int[]{2,3,4,6};
        oneseventwosix s = new oneseventwosix();
        System.out.println(s.tupleSameProduct(zaza));
    }
}
