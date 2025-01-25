package leetcodeproblrms;

public class dp56 {
    public static int countSquares(int[][] matrix) {
        int ans =0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){if(matrix[i][0]==1){ans++;}dp[i][0]=matrix[i][0];}
        for(int i=1;i<matrix[0].length;i++){if(matrix[0][i]==1){ans++;}dp[0][i]=matrix[0][i];}
        for(int i =1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    ans+=dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(countSquares(matrix));
    }
}
