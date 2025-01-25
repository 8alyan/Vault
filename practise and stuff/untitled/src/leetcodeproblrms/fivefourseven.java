package leetcodeproblrms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class fivefourseven {
    public int findCircleNum(int[][] isConnected) {
        int ans =0;
        boolean[] vis = new boolean[isConnected.length];
        for(int i =0;i<vis.length;i++){
            if(!vis[i]){
                dfs(i,isConnected,vis);
                ans++;
            }
        }
        return ans;
}

    private void dfs(int i, int[][] isConnected, boolean[] vis) {
        Queue<Integer> dfss = new LinkedList<>();
        dfss.offer(i);
        while(!dfss.isEmpty()){
            int last = dfss.poll();
            if (vis[last]){continue;}
            vis[last]=true;
            for (int j = 0; j <vis.length; j++) {
                if (isConnected[last][j]!=0){
                    dfss.add(j);
                }
            }
        }

    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int ans =0;
        boolean[] vis = new boolean[V];
        for(int i =0;i<V;i++){
            if(!vis[i]){
                ans++;
                bfs(adj,i,V,vis);
            }
        }
        return ans;
    }

    private static void bfs(ArrayList<ArrayList<Integer>> adj, int i, int V,boolean[] vis) {
        if(vis[i]){return;}
        vis[i]=true;
        for (int j = 0; j <V; j++) {
            if (adj.get(i).get(j)!=0){
                bfs(adj,j,V,vis);
            }
        }
    }

    public static void main(String[] args) {
        fivefourseven g = new fivefourseven();
        System.out.println(g.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }
    }
