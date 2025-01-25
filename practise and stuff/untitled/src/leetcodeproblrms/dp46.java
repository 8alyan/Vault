package leetcodeproblrms;

public class dp46 {
    public static int LongestBitonicSequence(int n, int[] nums) {
        int[] dp = new int[n];
        int[] mp = new int[n];
        int maxi=1;
        for(int i =0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]&&dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        for(int i =n-1;i>=0;i--){
            for(int j =n-1;j>i;j--){
                if(nums[j]<nums[i]&&mp[i]<mp[j]+1){
                    mp[i]=mp[j]+1;
                    maxi=Math.max(mp[i]+dp[i]+1,maxi);
                }
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        System.out.println(LongestBitonicSequence(6,new int[]{33,26, 38, 53 ,58, 92}));
    }
}
