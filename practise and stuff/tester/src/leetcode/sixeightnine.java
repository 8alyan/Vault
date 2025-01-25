package leetcode;

import java.util.*;

public class sixeightnine {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        Map<String,int[]> map = new HashMap<>();
        return helper(nums,0,k,new int[]{-1,-1,-1},0,map);

    }
    public static int[] helper(int[] nums, int i, int k, int[] ans, int j, Map<String, int[]> map){
        if(j==3){return new int[]{ans[0],ans[1],ans[2]};}
        if(i>=nums.length){return null;}
        if(map.containsKey(i+" "+j)){return map.get(i+" "+j);}
        int[] c1=new int[]{-1,-1,-1};
        int[] c2;
        if(!(i+k>nums.length)){
            ans[j]=i;
            c1 = helper(nums,i+k,k,ans,j+1, map);
            ans[j]=-1;
        }
        c2=helper(nums, i+1, k, ans, j, map);
        int[] lo=maxi(c1,c2,nums,k);
        map.put(i+" "+j,lo);
        return lo;

    }

    private static int[] maxi(int[] c1, int[] c2, int[] nums,int k) {
        if(c1==null){return c2;}
        if(c2==null){return c1;}
        int c11 =0;
        int c22 =0;
        for (int l:c1){
            if(l==-1){c11=0;break;}
            for (int i = l; i <l+k ; i++) {
                c11+=nums[i];
            }
        }
        for (int l:c2){
            if(l==-1){c22=0;break;}
            for (int i = l; i <l+k ; i++) {
                c22+=nums[i];
            }
        }
        return c22>c11?c2:c1;
    }







    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2)));
    }
}
