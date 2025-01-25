package leetcodeproblrms;

import java.util.HashMap;
import java.util.*;

public class dp50 {
    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] cut = new int[cuts.length + 2];
        System.arraycopy(cuts, 0, cut, 1, cuts.length);
        cut[cuts.length + 1] = n;
        int[][] dp = new int[cuts.length + 2][cuts.length + 2];
        // dp[i+1]==cuts[i];
        for (int i = cut.length - 2; i >= 0; i--) {
            for (int j = i+1; j < cut.length ; j++) {
                int mini = (int) (1e9);
                boolean b =false;
                for (int k = i + 1; k < j; k++) {
                    b=true;
                    int r = cut[j] - cut[i];
                    int m = dp[i][k] + dp[k][j];
                    mini = Math.min(mini, r + m);
                }
                if(b){dp[i][j] = mini;}
                else{dp[i][j]=0;}
            }
        }
        return dp[0][cuts.length + 1];
    }
    public static int what(int[][] dp, int i ,int j,int[] cut){
        if(i==j||i+1==j){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        int mini = (int)(1e9);
        for(int k =i+1;k<j;k++){
            int r = cut[j]-cut[i];
            int m =what(dp,i,k,cut)+what(dp,k,j,cut);
            mini =Math.min(mini,r+m);
        }
        return mini;

    }

    public static void main(String[] args) {
        System.out.println(minCost(7,new int[]{1,3,4,5}));
    }
}
