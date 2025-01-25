package leetcodeproblrms;

public class twoninefiveeight {
    public static int maxSubarrayLength(int[] nums, int k) {
        int maxi =0;
        int lessi =Integer.MAX_VALUE;
        for (int n:nums){
            maxi=Math.max(maxi,n);
            lessi=Math.min(lessi,n);
        }
        lessi--;
        int[] fre = new int[maxi-lessi];
        lessi++;
        int max =0;
        int ans=0;
        for(int right =0,left =0;right<nums.length;right++){
            fre[nums[right]-lessi]++;
            max=Math.max(fre[nums[right]-lessi],max);
            if(max>k){
                max--;
                while(nums[left]!=nums[right]){
                    fre[nums[left]-lessi]--;
                    left++;
                }
                fre[nums[left]-lessi]--;
                left++;}

            ans=Math.max(ans,right-left+1);

        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println( maxSubarrayLength(new int[]{3,1,1},1));
    }


}
