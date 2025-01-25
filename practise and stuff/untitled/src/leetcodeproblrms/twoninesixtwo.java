package leetcodeproblrms;

public class twoninesixtwo {
    public static long countSubarrays(int[] nums, int k) {
        int max = 0;
        if (k> nums.length){return 0;}
        for(int n:nums){
            max=Math.max(max,n);
        }
        int freq=0;
        int ans =0;
        for(int right =0,left=0;right< nums.length;right++){
            if (nums[right]==max){freq++;}
            if (freq>=k){
            while (freq>=k){
                if (nums[left]==max){freq--;}
                left++;
            }
            left--;
            freq++;
            ans+=left+1;}
        }
    return ans;
    }

    public static void main(String[] args) {

        System.out.println( countSubarrays(new int[]{1,3,2,3,3},2));
    }
}
