package leetcodeproblrms;

public class onezerotwozero {
    public  static int numEnclaves(int[][] grid) {
        int ans = 0;
        int notans =0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if (grid[i][j]==1){
                    ans++;
                    if (i==0||i==grid.length-1||j==0||j==grid[0].length-1){
                       notans+=dfs(grid,i,j,vis);
                    }
                }
            }
        }
        return ans-notans;
    }

    private static int dfs(int[][] grid, int i, int j, boolean[][] vis) {
        if (i<0||i==grid.length||j<0||j==grid[0].length||grid[i][j]!=1){return 0;}
        if (vis[i][j]){return 0;}
        vis[i][j]=true;
        int a = dfs(grid,i+1,j,vis);
        int b = dfs(grid,i-1,j,vis);
        int c = dfs(grid,i,j+1,vis);
        int d = dfs(grid,i,j-1,vis);
        return a+b+c+d+1;
    }

    public static void main(String[] args) {
        System.out.println(numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}
        }));
    }
}
