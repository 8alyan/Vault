package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class onefive{
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]){continue;}
            int l = i+1;
            int r = nums.length-1;
            while(r>l){
                while((l!=i+1&&l<r)&&nums[l]==nums[l-1]){l++;}
                while((r!=nums.length-1&&r>l)&&nums[r]==nums[r+1]){r--;}
                if(r<=l){break;}
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);
                    l++;
                    r--;
                }
                else if(sum>0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2,0,0,2,2}));
    }
}
