package leetcodeproblrms;

import java.util.Arrays;

public class threeone {
    public static void nextPermutation(int[] nums) {
        int r =nums.length-1;

            while(r>0&&nums[r]<=nums[r-1]){
              r--;
            }
            Arrays.sort(nums,r, nums.length);
            if (r==0){return;}
            int l = r-1;
            while(r<nums.length&&nums[l]>=nums[r]){r++;}
            if(r< nums.length){
              int temp = nums[l];
              nums[l]=nums[r];
              nums[r]=temp;
            }



        for (int n :nums){
            System.out.print(n+",");
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{5,1,1});

    }
}
