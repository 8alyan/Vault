package leetcode;

import java.util.*;

public class fournine {
        public static List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> map = new HashMap<>();
            for (String l :strs){
                int[] z = pasifier(l);
                String r = Arrays.toString(z);
                if(map.containsKey(r)){
                    map.get(r).add(l);
                }else{
                    List<String> temp = new ArrayList<>();
                    temp.add(l);
                    map.put(r,temp);
                }
            }
            List<List<String>> ans= new ArrayList<>();
             ans.addAll(map.values());
             return ans;
        }

        private static int[] pasifier(String l) {
          int[] ans = new int[26];
          for (char r :l.toCharArray()){
              ans[r-'a']++;
          }
          return ans;
        }

    public static void main(String[] args) {
       String z = "rat";
       char[] l = z.toCharArray();
       Arrays.sort(l);
        String m = new String(l);
        System.out.println(m);
    }
}
