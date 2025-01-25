package leetcodeproblrms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threesixeight {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer>[][] dp = new List[nums.length][nums.length];
        Arrays.sort(nums);
        return helper(dp,nums,0,-1);
    }
    public List<Integer> helper(List[][] dp ,int[] nums,int index,int ls){
        if(index== nums.length){return new ArrayList<>();}
        if (ls!=-1&&dp[index][ls]!=null){return dp[index][ls];}
        List<Integer> temp = new ArrayList<>();

        if (ls==-1||nums[index]%nums[ls]==0){
            temp.add(nums[index]);
            temp.addAll(helper(dp,nums,index+1,index));
        }
        List<Integer> tem = helper(dp,nums,index+1,ls);
        if (tem.size()>=temp.size()){return dp[index][ls]=tem;}
        else return dp[index][ls]=temp;
    }
    public static ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        // Code here
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp,1);
        for(int i =0;i<n;i++){
            hash[i]=i;
        }
        int maxi = 1;
        int lasi=0;
        for(int i =0;i<n;i++){
            for(int j =0;j<i;j++){
                if(arr[i]>arr[j]&&dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(maxi<dp[i]){maxi=dp[i];lasi=i;}
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();

        while(hash[lasi]!=lasi){
            ans.add(0,arr[lasi]);
            lasi=hash[lasi];
        }
        ans.add(0,arr[lasi]);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(16,new int[]{0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}));
    }
}
