package leetcodeproblrms;

public class ninjatraining {
     static int ans =0;
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][3];
        dp[points.length-1][0]=points[points.length-1][0];
        dp[points.length-1][1]=points[points.length-1][1];
        dp[points.length-1][2]=points[points.length-1][2];
        for (int i =points.length-2; i>=0 ; i--) {
            for (int j = 0; j <3 ; j++) {
                for (int k = 0; k <3 ; k++) {
                    if (k==j){continue;}
                    dp[i][j]=Math.max(dp[i][j],points[i][j]+dp[i+1][k]);
                }
            }
        }
        return Math.max(Math.max(dp[0][0],dp[0][1]),dp[0][2]);
    }

    private static void recu(int i, int[][] points, int j,int k) {
        if(j== points.length){ans=Math.max(i,ans);return;}
        for (int l = 0; l <3 ; l++) {
            if (k==l){continue;}
            recu(i+points[j][l],points,j+1,l);
        }

    }

    public static void main(String[] args) {
        System.out.println(ninjaTraining(3,new int[][]{{1,2,5},{3,1,1},{3,3,3}}));
    }
}
