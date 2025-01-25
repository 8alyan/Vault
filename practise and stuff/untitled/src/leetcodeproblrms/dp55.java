package leetcodeproblrms;

import java.util.Arrays;
import java.util.Stack;

public class dp55 {
    public int maximalRectangle(char[][] matrix) {
        int[][][] and =new int[2][matrix.length][matrix[0].length];
        int[][] mat= new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if (matrix[i][j]=='1'){mat[i][j]++;
                    if (i!=0){mat[i][j]+=mat[i-1][j];}}}}
        for (int i = 0; i <mat.length ; i++) {
                Arrays.fill(and[0][i],mat[0].length);
                Arrays.fill(and[1][i],-1);
                Stack<Integer> stack = new Stack<>();
                for(int j =0;j<mat[0].length;j++){
                    if(stack.isEmpty()){stack.add(j);continue;}
                    if(mat[i][stack.peek()]>mat[i][j]){
                        while(!stack.isEmpty()&&mat[i][stack.peek()]>mat[i][j]){
                            and[0][i][stack.peek()]=j;
                            stack.pop();
                        }
                        if(!stack.isEmpty()){
                            and[1][i][j]=stack.peek();
                        }
                        stack.push(j);
                    }else {
                        and[1][i][j]=stack.peek();
                        stack.push(j);
                    }
                }
            }
        int ans =0;
        for(int i =0;i<mat.length;i++){
            for (int j =0;j<mat[0].length;j++){
            ans=Math.max(ans,mat[i][j]*(and[0][i][j]-and[1][i][j]-1));
        }}
        return ans;

        }
    }

