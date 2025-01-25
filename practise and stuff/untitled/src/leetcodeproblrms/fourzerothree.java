package leetcodeproblrms;

import java.util.*;

public class fourzerothree {
    public static boolean canCross(int[] stones) {
        int target = stones[stones.length-1];
        Set<Integer> set = new HashSet<>();
        for (int n : stones){
            set.add(n);
        }
      PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
      pq.add(new int[]{0,0});
      while (!pq.isEmpty()){
          int[] pair = pq.remove();
          int s =pair[0];
          int c =pair[1];
          if (set.contains(s)) {
              set.remove(s);
              if (s == target) {
                  return true;
              }
              if (set.contains(s + c)) {
                  pq.add(new int[]{s + c, c});
              }
              if (set.contains(s + c - 1)) {
                  pq.add(new int[]{s + c - 1, c - 1});
              }
              if (set.contains(s + c + 1)) {
                  pq.add(new int[]{s + c + 1, c + 1});
              }
              set.add(s);
          }
      }
       return false;
    }

    public static int frogJump(int n, int heights[]) {
        int[] tb = new int[n];
        Arrays.fill(tb,Integer.MAX_VALUE);
       return recuu(n-1,heights,tb);

    }

    private static int recuu(int n, int[] heights, int[] tb) {
      if (n==0){return 0;}
      if (tb[n]!=Integer.MAX_VALUE){return tb[n];}
      int left = recuu(n-1,heights,tb)+Math.abs(heights[n]-heights[n-1]);
      int right = n>1?recuu(n-2,heights,tb)+Math.abs(heights[n]-heights[n-2]):Integer.MAX_VALUE;
      int zam = Math.min(left,right);
      if(tb[n]>zam){tb[n]=zam;}
        return  zam;
    }

    public int longestPalindrome(String s) {
        int[] table = new int[70];
        for (char r :s.toCharArray()){
            table[(int)(r-'A')]++;
        }
        int ans =0;
        boolean b = false;
        for(int n : table){
            if (!b&&n%2==1){b=true;}
            if (n%2==0){
                ans+=n;
            } else if (n>2){
                ans+=n-1;
            }
        }
        return b?ans+1:ans;
    }
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] tb = new int[27];
        for (int i = 0; i < words.length ; i++) {
            int[] lb = new int[27];
            for (char r : words[i].toCharArray()){
                    lb[(int)(r-'a')]++;
            }
            if (i==0){
                for (int j = 0; j <lb.length ; j++) {
                    tb[j]=lb[j];
                }
                continue;
            }
            for (int j = 0; j <lb.length ; j++) {
               if (lb[j]!=tb[j]){tb[j]=0;}
            }
        }
        for (int i = 0; i <tb.length ; i++) {
            while(tb[i]!=0){
                ans.add(""+(char)('a'+i));
                tb[i]--;
            }
        }
        return ans;
    }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length%groupSize!=0){return false;}
        Map<Integer,Integer> hm = new TreeMap<>();
        for(int n : hand){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        for(int k:hm.keySet()){
            int v = hm.get(k);
            if(v>0){
            for (int i = k; i <groupSize+k ; i++) {
                if (hm.getOrDefault(i,0)<v){return false;}
                hm.put(i,hm.getOrDefault(i,0)-v);
            }}
        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));
    }
}
