package leetcodeproblrms;

public class foursixthree {
    int ans =0;
    public int islandPerimeter(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
               if (grid[i][j]==1&&!vis[i][j]){
                   helper(grid,vis,i,j);
               }
            }
        }
        return ans;
    }

    private void helper(int[][] grid, boolean[][] vis,int i ,int j ) {
        if (vis[i][j]){return;}
        vis[i][j]=true;
        if (i==0||grid[i-1][j]==0){ans++;}else{helper(grid,vis,i-1,j);}
        if (i==grid.length-1||grid[i+1][j]==0){ans++;}else{helper(grid,vis,i+1,j);}
        if (j==0||grid[i][j-1]==0){ans++;}else{helper(grid,vis,i,j-1);}
        if (j== grid[0].length-1||grid[i][j+1]==0){ans++;}else{helper(grid,vis,i,j+1);}
    }
}
