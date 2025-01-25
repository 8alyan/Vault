package leetcodeproblrms;

import java.util.LinkedList;
import java.util.Queue;

public class seveneightfive {
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        boolean[] visi = new boolean[graph.length];
        for (int i = 0; i < graph.length ; i++) {
            if (!visi[i]){
                if (dfs(graph,i,vis,visi)){return false;}
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int i, int[] vis, boolean[] visi) {
        if (visi[i]){return false;}
        if (vis[i]==0){vis[i]=1;}
        for (int j = 0; j < graph[i].length ; j++) {
            int dest = graph[i][j];
            if (vis[dest]==0){
                if (vis[i]==1){vis[dest]=2;}
                if (vis[i]==2){vis[dest]=1;}
                if(dfs(graph,dest,vis,visi)){return true;}
            } else if (vis[dest]==vis[i]) {
                return true;
            }


    }
        return false;
    }

    private boolean bfs(int[][] graph, int i,int[] vis,boolean[] visi) {
        vis[i]=1;
        Queue<Integer> k = new LinkedList<>();
        k.add(i);
        while(!k.isEmpty()){
            int s = k.remove();
            if(visi[s]){continue;}
            visi[s]=true;
            for (int j = 0; j < graph[s].length ; j++) {
                int dest = graph[s][j];
                if (vis[dest]==0){
                if (vis[s]==1){vis[dest]=2;}
                if (vis[s]==2){vis[dest]=1;}
                k.add(dest);} else if (vis[dest]==vis[s]) {
                    return true;
                }


            }

        }
        return false;
    }
}
