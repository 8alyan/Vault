package leetcodeproblrms;

import java.util.*;

public class dpfive {
     static int ans =0;
    public static int maximumNonAdjacentSum(int[] nums) {
        if(nums.length==1){return nums[0];}
        int p = 0;
        int n = nums[0];
        int a =0;
        for(int i =1 ;i<nums.length-1;i++){
            a=Math.max(p+nums[i],n);
            p=n;
            n=a;
        }
        a=n;
        p=0;
        n=nums[1];
        int ae=0;
        for(int i =2;i<nums.length;i++){
            ae=Math.max(p+nums[i],n);
            p=n;
            n=ae;
        }
        return Math.max(a,n);
    }

    private static int recu(int i,int sum , ArrayList<Integer> nums,int[] dp) {
        if (i>=nums.size()){return sum;}
        if (dp[i]!=0){return sum+dp[i];}

      int l =  recu(i+1,sum,nums,dp);
      int r =  recu(i+2,sum+ nums.get(i),nums,dp);
      dp[i]=Math.max(l,r);
        return Math.max(l,r);
    }

    public  static String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        String[] ans = sentence.split(" ");
       for (int i =0;i<ans.length;i++){
           StringBuilder s = new StringBuilder();
           for(char r :ans[i].toCharArray()){
               s.append(r);
               if(set.contains(s.toString())){
                   ans[i]=s.toString();
                   break;
               }
           }
       }
        return String.join(" ",ans);

    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] pt = new int[nums.length+1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =1;i<pt.length;i++){
            pt[i]=(pt[i-1]+nums[i-1])%k;
            if(i-map.getOrDefault(pt[i],i)>2){return true;}
          else if(!map.containsKey(pt[i])){map.put(pt[i],i );}
        }
        return false;
    }
    public int heightChecker(int[] heights) {
        int[] n = new int[heights.length];
        System.arraycopy(heights, 0, n, 0, heights.length);
        Arrays.sort(heights);
        int ans =0;
        for(int i =0;i<heights.length;i++){
            if(n[i]!=heights[i]){ans++;}
        }
        return ans;
    }
    public int minMovesToSeat(int[] seats, int[] students) {
       Arrays.sort(seats);
       Arrays.sort(students);
       ans=0;
        for (int i = 0; i <seats.length ; i++) {
            ans+=Math.abs(seats[i]-students[i]);
        }
          return ans;

    }

    public static void main(String[] args) {
        System.out.println(maximumNonAdjacentSum(new int[]{2,1}));


    }
}
