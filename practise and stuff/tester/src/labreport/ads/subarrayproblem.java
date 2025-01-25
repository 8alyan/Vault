package labreport.ads;

public class subarrayproblem {

    public static int subarray(int[] nums){
        int sum =0;
        int mx =0;
        for (int i = 0; i < nums.length ; i++) {
            if (sum+nums[i]>=0){
                sum+=nums[i];
            }
            else{
                sum=0;
            }
            if (sum>mx){
                mx=sum;
            }
        }
        if (mx==0){
            mx=Integer.MIN_VALUE;
            for (int j = 0; j < nums.length ; j++) {
                mx=Math.max(mx,nums[j]);
            }
        }
        return mx;
    }


    public static void main(String[] args) {
        int[] zaza = new int[]{2,3,-8,7,-1,2,3};
        System.out.print(subarray(zaza));
    }
}
