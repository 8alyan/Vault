package leetcodeproblrms;

public class cherrypickup {
    public static int cherryPickup(int[][] grid) {
        int[][][][] dp = new int[grid.length][grid.length][grid[0].length][grid[0].length];
       return rec(grid,0,0,0,0,dp);

    }

    private static int rec(int[][] grid, int i1, int j1, int i2, int j2, int[][][][] hm ) {
        if (j1<0||j1>grid[0].length||j2<0||j2>grid[0].length||i1>=grid.length||i2>= grid.length){return (int)(-1e9);}
        if (grid[i1][j1]==-1||grid[i2][j2]==-1){return (int)(-1e9);}
        if (i1==grid.length-1&&j1==grid[0].length-1){return grid[i1][j1];}
        String r = i1+" "+j1+"/"+i2+" "+j2;
        if (hm[i1][i2][j1][j2]!=0){return hm[i1][i2][j1][j2];}
        int s = grid[i1][j1]+grid[i2][j2];
        if (i1==i2&&j1==j2){s=grid[i1][j1];}
        int a = rec(grid,i1+1,j1,i2,j2+1,hm)+s;
        int b = rec(grid,i1,j1+1,i2+1,j2,hm)+s;
        int c = rec(grid,i1+1,j1,i2+1,j2,hm)+s;
        int d = rec(grid,i1,j1+1,i2,j2+1,hm)+s;
        hm[i1][i2][j1][j2]=Math.max(Math.max(a,b),Math.max(c,d));
        return hm[i1][i2][j1][j2];


    }


    public static int maximumChocolates(int r, int c, int[][] grid) {
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{{0,1,-1},{1,0,-1},{1,1,1}}));
    }
}
