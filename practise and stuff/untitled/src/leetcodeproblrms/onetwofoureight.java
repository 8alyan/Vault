package leetcodeproblrms;

public class onetwofoureight {
    public static int numberOfSubarrays(int[] nums, int k) {
        int ans =0;
        int count =0;
        int left =0;
        for (int right = 0; right <nums.length ; right++) {
            if (nums[right]%2==1){count++;}
            if (count==k){
                int a =1;
                int b =1;
                while(nums[left]%2!=1){
                    left++;
                    a++;
                }
                while(right<nums.length-1&&nums[right+1]%2!=1){
                    right++;
                    b++;
                }
                ans+=a*b;
                left++;
                count--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2},2));
    }
}
