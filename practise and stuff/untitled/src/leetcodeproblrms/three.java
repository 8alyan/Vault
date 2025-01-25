package leetcodeproblrms;

import java.util.Arrays;
import java.util.HashMap;

public class three {
    int maxLen(int arr[], int n){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int[] ans = new int[arr.length];
        int r =0;
        int z =0;
        for (int i = 0; i < arr.length ; i++) {
            z+=arr[i];
            if (!hm.containsKey(z)){hm.put(z,i);}
            else{r=Math.max(r,i-hm.get(z));}
            ans[i]=z;
        }

        return r;
    }
        public static int lengthOfLongestSubstring(String s) {
           int left =0;
           int right=0;
           int last2 =-1;
           int ans =0;
           int[] tb = new int[256];
           while (right<s.length()){
               while(last2==-1&&right<s.length()){
                   tb[s.charAt(right)]++;
                   if (tb[s.charAt(right)]==2){
                       last2=s.charAt(right);
                      ans=Math.max(ans,right-left);
                   }right++;
               }
               while (last2!=-1){
                   tb[s.charAt(left)]--;
                   if (s.charAt(left)==last2){
                       last2=-1;
                   }
                   left++;
               }

           }
           return Math.max(ans,right-left);
        }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("b"));
    }
}
