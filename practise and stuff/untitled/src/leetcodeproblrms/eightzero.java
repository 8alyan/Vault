package leetcodeproblrms;

public class eightzero {
    public int removeDuplicates(int[] nums) {
        int left =0;
        int count=0;
        int f1=nums[0];
        int ans =0;
        for (int right = 0; right < nums.length ; right++) {
            if (f1==nums[right]){
                count++;
                if (count<=2){
                    nums[left]=nums[right];
                    left++;
                }
            }
            else{
                f1=nums[right];
                count=1;
                nums[left]=nums[right];
                left++;
            }
        }
        return ans;
    }
}
