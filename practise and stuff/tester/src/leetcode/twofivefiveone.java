package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class twofivefiveone {
    public static long putMarbles(int[] weights, int k) {
        if(weights.length==k){return 0;}
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i<weights.length ; i++) {
            ans.add(weights[i]+weights[i-1]);
            pq.add(weights[i]+weights[i-1]);
        }
        int zaza= 0;
        Collections.sort(ans);
        for (int i = 0; i <k-1; i++) {
            zaza+=ans.get((ans.size()-1)-i);
            zaza-=ans.get(i);
        }

        return zaza;
    }


    public static void main(String[] args) {
        int[] test  = new int[]{1,4,2,5,2};
        System.out.println(putMarbles(test,3));
    }

}
