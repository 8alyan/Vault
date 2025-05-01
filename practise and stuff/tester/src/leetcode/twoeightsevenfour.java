package leetcode;

public class twoeightsevenfour {
    public static long maximumTripletValue(int[] nums) {
        int[] pre = new int[nums.length];
        int[] pos = new int[nums.length];
        pre[0]=nums[0];
        pos[nums.length-1]=nums[nums.length-1];
        for(int i =1,j =nums.length-2;i<nums.length;i++,j--){
            pre[i]=Math.max(pre[i-1],nums[i]);
            pos[j]=Math.max(pos[j+1],nums[j]);
        }
        for (int n :pre){
            System.out.print(n+",");
        }
        System.out.println();
        for(int n :pos){
            System.out.print(n+",");
        }
        int ans =0;
        for(int i =1;i<nums.length-1;i++){
            ans=Math.max(ans,(pre[i-1]-nums[i])*pos[i+1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{12,6,1,2,7}));
    }
}
