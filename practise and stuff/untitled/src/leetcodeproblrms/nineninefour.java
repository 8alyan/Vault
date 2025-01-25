package leetcodeproblrms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class nineninefour {
    public int orangesRotting(int[][] grid) {
        int min = Integer.MAX_VALUE;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    min = Math.min(min,bfs(grid,i,j));
                }
            }
        }
        if(min==Integer.MAX_VALUE){return -1;}
        return min;

    }
    public int bfs(int[][] grid , int i , int j ){
        int[][] gr= new int[grid.length][grid[0].length];
        for (int k = 0; k < grid.length ; k++) {
            for (int l = 0; l <grid[0].length ; l++) {
                gr[k][l]=grid[k][l];
            }
        }
        int lvl = -1;
        Queue<int[]> ans = new LinkedList<>();
        ans.offer(new int[]{i,j});
        while(!ans.isEmpty()){
            int size = ans.size();
            lvl++;
            for(int k =0;k<size;k++){
                int[] temp = ans.remove();
                if(temp[0]<grid.length-1&&gr[temp[0]+1][temp[1]]==1){ans.offer(new int[]{temp[0]+1,temp[1]});gr[temp[0]+1][temp[1]]=2;}
                if(temp[0]>0&&gr[temp[0]-1][temp[1]]==1){ans.offer(new int[]{temp[0]-1,temp[1]});gr[temp[0]-1][temp[1]]=2;}
                if(temp[1]<grid[0].length-1&&gr[temp[0]][temp[1]+1]==1){ans.offer(new int[]{temp[0],temp[1]+1});gr[temp[0]][temp[1]+1]=2;}
                if(temp[1]>0&&gr[temp[0]][temp[1]-1]==1){ans.offer(new int[]{temp[0],temp[1]-1});gr[temp[0]][temp[1]-1]=2;}
            }
        }
        for(int[] mn : gr){
            for(int mno : mn){if (mno ==1){return Integer.MAX_VALUE;}}}
        return lvl;
    }

    public static void main(String[] args) {
        nineninefour h = new nineninefour();

        System.out.println(h.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
