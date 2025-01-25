package leetcodeproblrms;

public class dp18 {
    public static int countPartitions(int n, int d, int[] arr) {
        int S =0;
       for(int m:arr){
           S+=m;
       }
       int k = S-d;
       if ((S-d)%2==1||(S-d)<0){return 0;}
       int[][] dp = new int[arr.length][S+1];
        if (arr[0]==0){dp[0][0]=2;}
        else dp[0][0]=1;
        if (arr[0]!=0&&arr[0]<=S){dp[0][arr[0]]=1;}
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <= S; j++) {
                int np = dp[i - 1][j];
                int p = arr[i] <= j ? dp[i - 1][j - arr[i]] : 0;
                dp[i][j] = np + p;
            }
        }
        return dp[n-1][k/2];
    }
}
