package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class sixteenfeb {
    public boolean hasSpecialSubstring(String s, int k) {
        for(int i =0;i<s.length();i++){
            int[]freq = new int[26];
            boolean a = true;
            boolean b = true;
            for(int j =i;j<i+k&&j<s.length();j++){
                int r = s.charAt(j)-'a';
                freq[r]++;
                if(freq[r]==k){
                    if(j-k>=0){
                        int g = s.charAt(j-k)-'a';
                        if(g==r){a=false;}
                    }
                    if(j<s.length()-1){
                        int g = s.charAt(j+1)-'a';
                        if(g==r){a=false;}
                    }
                    if(a&&b){return true;}
                }
            }
        }
        return false;
    }
    public long maxWeight(int[] pizzas) {
        int n = pizzas.length/4;
        long ans=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o-> (int) o).reversed());
        for (int i = 0; i < pizzas.length ; i++) {
            pq.add(pizzas[i]);
        }
        for(int i =0;i<n-1;i++){
                ans+=pq.remove();
        }
        pq.remove();
        ans+=pq.remove();
        return ans;
    }

    public static void main(String[] args) {
        sixteenfeb s = new sixteenfeb();
        int[] test = new int[]{5,2,2,4,3,3,1,3,2,5,4,2};
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
        System.out.println(s.maxWeight(test));
    }

}
