package leetcodeproblrms;

public class onetwoonenine {
    int ans =0;
    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (grid[i][j]!=0){
                    dfs(grid,new boolean[grid.length][grid[0].length],i,j,0,new int[grid.length][grid[0].length]);}
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, boolean[][] vis,int i ,int j,int csum,int[][] msum) {
        if(vis[i][j]||grid[i][j]==0){return 0;}
        vis[i][j]=true;
        int left=0,right=0,up=0,down =0;
        if(i>0){
            up=dfs(grid,vis,i-1,j,csum,msum);
        }
        if(j>0){
            left=dfs(grid,vis,i,j-1,csum,msum);
        }
        if(i<grid.length-1){
            down=dfs(grid,vis,i+1,j,csum,msum);
        }
        if (j<grid[0].length-1){
            right=dfs(grid,vis,i,j+1,csum,msum);
        }
        msum[i][j]=grid[i][j]+Math.max(Math.max(up,down),Math.max(left,right));
        ans=Math.max(ans,msum[i][j]);
        vis[i][j]=false;
        return msum[i][j];
    }

    public static void main(String[] args) {
        onetwoonenine n = new onetwoonenine();
        System.out.println(n.getMaximumGold(new int[][]{
                {1, 0, 7, 0, 0, 0},
                {2, 0, 6, 0, 1, 0},
                {3, 5, 6, 7, 4, 2},
                {4, 3, 1, 0, 2, 0},
                {3, 0, 5, 0, 20, 0}
        }));

    }
}
