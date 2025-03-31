package leetcode;

import java.util.*;

public class twofivezerothree {
        public static int[] maxPoints(int[][] grid, int[] queries) {
            PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
            int[] oq =new int[queries.length];
            int[] ans = new int[queries.length];
            for(int i =0;i<queries.length;i++){
                oq[i]= queries[i];
            }
            Arrays.sort(oq);
            Map<Integer,Integer> map = new HashMap<>();
            boolean[][] vis = new boolean[grid.length][grid[0].length];
            q.add(new int[]{0,0,grid[0][0]});
            vis[0][0]=true;
            int cmax =0;
            int size =0;
            int k =0;
            while(!q.isEmpty()&&k<queries.length){
                int[] temp = q.peek();
                int i =temp[0];
                int j =temp[1];
                if(grid[i][j]<oq[k]){cmax++;}
                else{map.put(oq[k],cmax);k++;continue;}
                q.remove();
                if(i>0&&!vis[i-1][j]){q.add(new int[]{i-1,j,grid[i-1][j]});vis[i-1][j]=true;}
                if(j>0&&!vis[i][j-1]){q.add(new int[]{i,j-1,grid[i][j-1]});vis[i][j-1]=true;}
                if(i<grid.length-1&&!vis[i+1][j]){q.add(new int[]{i+1,j,grid[i+1][j]});vis[i+1][j]=true;}
                if(j<grid[0].length-1&&!vis[i][j+1]){q.add(new int[]{i,j+1,grid[i][j+1]});vis[i][j+1]=true;}
            }
            for(int i =0;i<queries.length;i++){
                ans[i]=map.get(queries[i]);
            }
            return ans;
        }

    public static void main(String[] args) {
        int[] ints = maxPoints(new int[][]{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}}, new int[]{5, 6, 2});
        for (int n :ints){
            System.out.println(n+",");}
    }
}
