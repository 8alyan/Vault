package leetcodeproblrms;

import java.util.HashMap;

public class fivethree {
    public static int maxSubArray(int[] nums) {
        int sum =0;
        int mx =0;
        for (int i = 0; i < nums.length ; i++) {
            if (sum+nums[i]>=0){
                sum+=nums[i];
            }
            else{
                sum=0;
            }
            if (sum>mx){
                mx=sum;
            }
        }
        if (mx==0){
            for (int j = 0; j < nums.length ; j++) {
               mx=Math.max(mx,nums[j]);
            }
        }
        return mx;
        }

    public static void main(String[] args) {
        maxSubArray(new int[]{1});
    }
}
