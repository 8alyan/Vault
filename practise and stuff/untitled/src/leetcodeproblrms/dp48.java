package leetcodeproblrms;

public class dp48 {
    static int matrixMultiplication(int N, int arr[]){
        int[][] dp = new int[N][N];
        for(int i =1;i<N;i++){
            for(int j =1;j<N;j++){
                if(i==j){continue;}
                int mini =Integer.MAX_VALUE;
                for (int k = i; k <=j-1 ; k++) {
                    int r = arr[i-1]*arr[k]*arr[j];
                    int m =dp[i][k]+dp[k+1][j];
                    mini=Math.min(mini,m+r);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][N-1];
    }

    public static void main(String[] args) {
        System.out.println(matrixMultiplication(5,new int[]{1,2,3,4,5}));

    }
}
