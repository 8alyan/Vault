package leetcodeproblrms;

public class sevennineone {
    public String customSortString(String order, String s) {
        int[] sd = new int[26];
        for (char d :s.toCharArray()){
            sd[d-'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for(char d : order.toCharArray()) {
            while (sd[d - 'a'] != 0) {
                ans.append(d);
                sd[d - 'a']--;
            }
        }
        int i =0;
       while(i<26){
           if(sd[i]==0){i++;}
           else{
               ans.append('a'+i);
               sd[i]--;
           }
       }
       return ans.toString();
    }
}
