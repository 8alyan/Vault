package leetcodeproblrms;

import java.util.Arrays;

public class onefoureighttwo {
    public static int minDays(int[] bloomDay, int m, int k) {
        int right =0;
        int left =0;
        for(int n :bloomDay){
            right=Math.max(right,n);
        }
        int p = -1;
        while(right>=left){
            int mid =left+(right-left)/2;
            int ki = k;
            int mi =0;
            for (int j : bloomDay) {
                if (mid >= j) {
                    ki--;
                    if (ki == 0) {
                        mi++;
                        ki = k;
                    }
                } else if ( ki != k) {
                    ki = k;
                }
            }
            if (mi>=m){
                p=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{7,7,7,7,12,7,7},2,3));
    }
}
