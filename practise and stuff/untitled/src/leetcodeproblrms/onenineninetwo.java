package leetcodeproblrms;

import java.util.*;

public class onenineninetwo {
    public static int[][] findFarmland(int[][] land) {
        List<int[]> ansd = new ArrayList<>();
        for (int i = 0; i < land.length ; i++) {
            for (int j = 0; j < land[0].length ; j++) {
                if (land[i][j]==1){
                    ansd.add(dfs(land,i,j));
                }
            }
        }
        return ansd.toArray(new int[ansd.size()][]);
    }

    private static int[] dfs(int[][] land, int i, int j) {
        int[] ans = new int[]{i,j,i,j};
        int r =i;
        int c =j;
       while (r<land.length-1&&land[r+1][j]==1){r++;}
       while (c<land[0].length-1&&land[i][c+1]==1){c++;}
        for (int k = i; k <=r ; k++) {
            for (int l = j; l <=c ; l++) {
                land[k][l]=0;
            }
        }
        ans[2]=r;
        ans[3]=c;
        return ans;
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] edge = new ArrayList[n];
        boolean[] vis = new boolean[n];
        for (int i = 0; i <n ; i++) {
            edge[i]= new ArrayList<>();
        }
        for(int[] m:edges){
            edge[m[0]].add(m[1]);
            edge[m[1]].add(m[0]);

        }
        return dfss(edge,vis,source,destination);
    }

    private static boolean dfss(ArrayList<Integer>[] edge,boolean[] vis, int source, int destination)
    {
        if (source==destination){return true;}
        if (vis[source]){return false;}
        vis[source] = true;
        for (int i = 0; i <edge[source].size() ; i++) {
            if (dfss(edge,vis,edge[source].get(i),destination)){return true;}
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validPath(3,new int[][]{{0,1},{1,2},{2,0}},0,2));
    }

}
