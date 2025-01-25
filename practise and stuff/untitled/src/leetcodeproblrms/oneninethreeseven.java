package leetcodeproblrms;

import java.util.Arrays;

public class oneninethreeseven {
    public static long maxPoints(int[][] points) {
        long[][] dp = new long[points.length][points[0].length];
        for (long[] n : dp){
            Arrays.fill(n,-1);
        }
        for (int i = 0; i <points[0].length ; i++) {
            dp[0][i]=points[0][i];
        }
        for (int i = 1; i <points.length ; i++) {
            for (int j = 0; j <points[0].length ; j++) {
                long d =0;
                for (int k = 0; k <points[0].length ; k++) {
                    d=Math.max(d,(points[i][j]+dp[i-1][k]-Math.abs(j-k)));
                }   dp[i][j]=d;
            }
        }
        long ans =0;
        for (int i = 0; i <points[0].length ; i++) {
            ans =Math.max(ans,dp[points.length-1][i]);
        }
        return ha(dp,points, points.length-1,-1);
    }
    public static long ha(long[][]dp,int[][] points,int r,int c){
        if ((r>=0&&c!=-1)&&dp[r][c]!=-1){return dp[r][c];}
        if(r<0){return 0;}
        if(c==-1){
            long d =0;
            for (int i = 0; i <points[0].length ; i++) {
                long g =points[r][i]+ha(dp,points,r-1,i);
                d=Math.max(d,points[r][i]+ha(dp,points,r-1,i));
            }
            return d;
        }else{
            long d =0;
            for (int i = 0; i <points[0].length ; i++) {
                d=Math.max(d,(points[r][i]-Math.abs(i-c))+ha(dp,points,r-1,i));
            }
            dp[r][c]=d;
            return d;
        }
    }

    public static void main(String[] args) {
        int[][] j = new int[][]{{1,2,3},{1,5,1},{3,1,1}};
        System.out.println(maxPoints(j));
    }
}
