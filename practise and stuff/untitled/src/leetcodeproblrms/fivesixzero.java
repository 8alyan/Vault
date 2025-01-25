package leetcodeproblrms;

public class fivesixzero {
    public static int subarraySum(int[] nums, int k) {
        return recu(nums,k,0,0);
    }

    private static int recu(int[] nums, int k,int s,int i ) {
        if (s==k){return 1;}
        if (i>= nums.length){return 0;}
        int b = recu(nums,k,s+nums[i],i+1);
        int a = recu(nums,k,s,i+1);

        return a+b;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }
}
