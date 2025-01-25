package leetcodeproblrms;

import java.util.*;

public class dp26 {
    public static List<String> all_longest_common_subsequences(String s, String t) {
        int[][] ans = new int[s.length()][t.length()];
        for (int[] z:ans){
            Arrays.fill(z,-1);
        }
        subseq(ans,s,t,s.length()-1,t.length()-1);
        Set<String> a = new TreeSet<>();
                dd(a,ans,s,t,s.length()-1,t.length()-1,"");
                List<String> sd = new ArrayList<>(a);

        return sd;
    }

    private static void dd(Set<String> a,int[][] ans,String s ,String t,int i ,int j,String m) {
        if(i<0||j<0){a.add(m);return;}
        if (s.charAt(i)==t.charAt(j)){
            dd(a,ans,s,t,i-1,j-1,s.charAt(i)+m);
        } else{
            if (i>0&&ans[i][j]==ans[i-1][j]){
                dd(a,ans,s,t,i-1,j,m);
            }
            if (j>0&&ans[i][j]==ans[i][j-1]){
                dd(a,ans,s,t,i,j-1,m);
            }
        }

    }

    public static int subseq(int[][] ans, String s,String t, int i1, int i2){
        if (i1<0||i2<0){return 0;}
        if (ans[i1][i2]!=-1){return ans[i1][i2];}
        if (s.charAt(i1)==t.charAt(i2)){
            ans[i1][i2]=1+subseq(ans,s,t,i1-1,i2-1);

        }else{
            ans[i1][i2]=Math.max(subseq(ans,s,t,i1-1,i2),subseq(ans,s,t,i1,i2-1));
        }
        return ans[i1][i2];

    }

    public static void main(String[] args) {
        System.out.println(all_longest_common_subsequences("aababbb", "bbbaababababb"));
    }
}
