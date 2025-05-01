package leetcode;

public class twofivesixthree {
        public static long countFairPairs(int[] nums, int lower, int upper) {
            long ans =0;
            int highest=Integer.MAX_VALUE;
            int lowest=Integer.MIN_VALUE;
            for(int i =0;i<nums.length;i++){
                if(highest!=Integer.MAX_VALUE&&highest<nums[i]){continue;}
                if(lowest!=Integer.MIN_VALUE&&lowest>nums[i]){continue;}
                int r =0;
                for(int j =i+1;j<nums.length;j++){
                    if(nums[i]+nums[j]<=upper&&nums[i]+nums[j]>=lower){
                        r++;
                    }
                }
                    if(r==0){
                        int z = Math.abs(upper-nums[i]);
                        int y = Math.abs(lower-nums[i]);
                        if(y<z){lowest=Math.max(lowest,nums[i]);}
                        else{highest=Math.min(nums[i],highest);}}
                ans+=r;
            }
            return ans;
        }

    public static void main(String[] args) {
        int[] nums = {-1000000000,90,90,-1000000000,90,-1000000000,90,90,-1000000000,90,90,-1000000000,90,90,90,90,-1000000000,-1000000000,-1000000000,-1000000000,-1000000000,-1000000000,-1000000000,90,-1000000000,-1000000000,-1000000000,90,-1000000000,-1000000000,-1000000000,-1000000000,90,-1000000000,90};
        System.out.println(countFairPairs(nums,0,0));

    }
}
