package leetcode;

import java.util.ArrayList;
import java.util.List;

public class spiralmatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> ans = new ArrayList<>();
        helper(matrix,visited,0,0,ans,1);
        return ans;
    }
    public static void helper(int[][] matrix,boolean[][] vis,int i ,int j,List<Integer> ans,int d ){
        if(i>=matrix.length||i<0||j>=matrix[0].length||j<0||vis[i][j]){ return;}
        vis[i][j]=true;
        ans.add(matrix[i][j]);
        while(ans.size()!=matrix.length*matrix[0].length){
        if(d==1){
            helper(matrix,vis,i,j+1,ans,1);
            d=2;}
        if(d==2){
            helper(matrix,vis,i+1,j,ans,2);
            d=3;}
        if(d==3){
            helper(matrix,vis,i,j-1,ans,3);d=4;}
        if(d==4){
            helper(matrix,vis,i-1,j,ans,4);
            d=1;}}}

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
                {21, 22, 23, 24}
        };
        System.out.println(spiralOrder(array));

    }
}
