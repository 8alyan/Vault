package leetcodeproblrms;

public class ninethreezeo {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0;
        int right =0;
        int asum =nums[0];
        int ans =0;
        while(right>=left){
            if(asum<goal){
                right++;
                asum+=nums[right];
            }else if(asum==goal){
                ans++;
                if (right<nums.length-1){
                    right++;
                    asum+=nums[right];
                }
                else {
                    if (left==nums.length-1){return ans;}
                    asum-=nums[left];
                    left++;}

            }else{
                asum-=nums[left];
                left++;}
        }
        return ans;}

    public static void main(String[] args) {
        ninethreezeo d = new ninethreezeo();
        System.out.println(d.numSubarraysWithSum(new int[]{0,0,0,0,0},0));
    }
}
