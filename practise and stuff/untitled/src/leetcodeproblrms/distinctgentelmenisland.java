package leetcodeproblrms;

import java.util.*;


public class distinctgentelmenisland {
    static class pair{
        int a;
        int b;
        pair(int c ,int d){
            this.a=c;
            this.b=d;
        }


    }
     static int countDistinctIslands(int[][] grid) {
        Set<List<List<Integer>>> ans = new HashSet<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if (grid[i][j]==1&&!vis[i][j]){
                    ans.add(bfs(grid,i,j,vis));
                }
            }
        }
        return ans.size();
    }

    private static List<List<Integer>> bfs(int[][] grid, int i, int j, boolean[][] vis) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<int[]> k = new LinkedList<>();
        k.add(new int[]{i,j});
        while(!k.isEmpty()){
            int[] pair = k.remove();
            if (vis[pair[0]][pair[1]]){continue;}
            vis[pair[0]][pair[1]]=true;
            List<Integer> jk = new ArrayList<>();
            jk.add(pair[0]-i);
            jk.add(pair[1]-j);
            ans.add(jk);
            if (pair[0]>0&&grid[pair[0]-1][pair[1]]==1){k.add(new int[]{pair[0]-1,pair[1]});}
            if (pair[0]<grid.length-1&&grid[pair[0]+1][pair[1]]==1){k.add(new int[]{pair[0]+1,pair[1]});}
            if (pair[1]>0&&grid[pair[0]][pair[1]-1]==1){k.add(new int[]{pair[0],pair[1]-1});}
            if (pair[1]<grid[0].length-1&&grid[pair[0]][pair[1]+1]==1){k.add(new int[]{pair[0],pair[1]+1});}
        }
        return ans;
    }

    public static void main(String[] args) {
      int k=  countDistinctIslands(new int[][]{{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}});
        System.out.println(k);

    }
}
