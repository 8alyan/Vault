package leetcodeproblrms;

import java.util.ArrayList;
import java.util.Arrays;

public class threefivezeo {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] fre = new int[1001];
        int[] fre2 = new int[1001];
        for(int n :nums1){
            fre[n]++;
        }
        int i =0;
        for(int n : nums2){
            if (fre[n]>0){
                fre2[i++]=n;
                fre[n]--;
            }
        }
        return Arrays.copyOfRange(fre2,0,i);
    }
}
