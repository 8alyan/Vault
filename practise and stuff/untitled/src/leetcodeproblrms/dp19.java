package leetcodeproblrms;

public class dp19 {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp =new int[n][maxWeight+1];
        for (int i = 0; i <=maxWeight ; i++) {
            if (weight[i]<=i){dp[0][i]=value[i];}
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <=maxWeight ; j++) {
                int np = dp[i-1][j];
                int p=weight[i]<=j?value[i]+dp[i-1][j-weight[i]]:Integer.MIN_VALUE;
                dp[i][j]=Math.max(np,p);

            }
        }
        return dp[n-1][maxWeight];

    }

    private static int chor(int[][] dp,int[] weight, int[] value, int n, int maxWeight, int i) {
        if (i==0){
            if (weight[0]<=maxWeight){return value[0];}
            else {return 0;}
        }
        if (dp[i][maxWeight]!=-1){return dp[i][maxWeight];}
        int np = chor(dp,weight,value,n,maxWeight,i-1);
        int p=weight[i]<=maxWeight?value[i]+chor(dp,weight,value,i-1,maxWeight-weight[i],i-1):Integer.MIN_VALUE;
        dp[i][maxWeight]=Math.max(np,p);
        return Math.max(np,p);
    }
}
