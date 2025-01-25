package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class twofivethreezero {
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> ans = new PriorityQueue<>(Comparator.reverseOrder());
        for(int n :nums){ans.add(n);}
        long zaza = 0;
        while(!ans.isEmpty()&&k!=0){
            k--;
            int r =ans.remove();
            zaza+=r;
            ans.add((int)Math.ceil((double)r/3));
        }
        return zaza;
    }

    public static void main(String[] args) {
        int[] r = new int[]{10,10,10,10,10};
        maxKelements(r,5);
    }
}
