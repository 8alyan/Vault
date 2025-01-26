package leetcode;

public class qthree {
    public static int maxFrequency(int[] nums, int k) {
        int[] table = new int[51];
        int r =0;
        for (int num : nums) {
            if (num == k) {
                r++;
            }
        }
        int left=0;
        int right=0;
        int ans =0;
        int max=0;
        int l =0;
        while(right>=left&&right< nums.length){
            table[nums[right]]++;
            max=Math.max(max,table[nums[right]]);
            if(nums[right]==k){
                ans=Math.max(ans,max);
                while(right>=left){
                    table[nums[left]]--;
                    left++;}
                right=left;
                max=0;
                table = new int[51];
                l++;
                r--;
            }else{
                ans=Math.max(ans,max+l+r);
                right++;}
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{32,32,19,30,28,3},32));

    }
}
