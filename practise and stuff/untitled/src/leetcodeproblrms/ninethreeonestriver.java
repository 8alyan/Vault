package leetcodeproblrms;

public class ninethreeonestriver {
    public static int minFallingPathSum(int[][] matrix) {
        int ans =Integer.MAX_VALUE;
        for (int i = matrix.length-2; i >=0 ; i--) {
            for (int j =matrix[0].length-1; j >=0 ; j--) {
                int a =matrix[i+1][j]+matrix[i][j];
                int b = j==0?(int)(1e9):matrix[i+1][j-1]+matrix[i][j];
                int c = j==matrix[0].length-1?(int)(1e9):matrix[i+1][j+1]+matrix[i][j];
                matrix[i][j]=Math.min(Math.min(a,b),c);
            }
        }
        for (int i = 0; i<matrix[0].length; i++) {
            ans=Math.min(ans,matrix[0][i]);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
    }
}
