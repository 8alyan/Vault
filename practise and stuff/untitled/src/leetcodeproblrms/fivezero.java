package leetcodeproblrms;

import java.util.*;

public class fivezero {
    public static List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int o1=0;
        int c1=0;
        int o2=0;
        int c2=0;
        for (int n :nums){
            if (c1==0){c1++;o1=n;}
            else if(c2==0){c2++;o2=n;}
            else if (n!=o1&&n!=o2){c1--;c2--;}
            else{
                if (n==o1){c1++;}
                else {c2++;}
            }
        }
        if (c1> nums.length/3){ans.add(o1);}
        if (c2> nums.length/3){ans.add(o2);}
        return ans;
    }
    public static double myPow(double x, int n) {
        return helper(x,n);
    }
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        for (int n :nums){
            hm.put(n,hm.getOrDefault(n,0)+1);
            if (hm.get(n)> nums.length/2){return n;}
        }
        return 0;
    }
    public static double helper(double x,int n){
        if (n==1){return x;}
        if (n==0){return 1;}
        if(n==-1){return 1/x;}
        double k = helper(x,n/2);
        return n%2==0?k*k:k*k*x;

    }

    public static void main(String[] args) {
        System.out.println(majorityElement2(new int[]{2,2,2,2,2,3}));
    }
}
