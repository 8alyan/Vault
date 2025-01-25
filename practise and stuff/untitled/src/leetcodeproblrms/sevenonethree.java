package leetcodeproblrms;

public class sevenonethree {

        public static int numSubarrayProductLessThanK(int[] nums, int k) {
            int ans = 0;
            int pro =1;
            for (int left = 0,right =0; right <nums.length ; right++) {
                pro*=nums[right];
                while (pro>=k){
                    pro/=nums[left];
                    left++;
                }
                ans+=right-left+1;
            }
            return ans;


        }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6},100));
    }
}
