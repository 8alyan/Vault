package leetcodeproblrms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestpathinUndirectedGraph {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        boolean[] vis = new boolean[n];
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        ans[src]=0;
        ArrayList<Integer>[] edge = new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            edge[i]= new ArrayList<>();
        }
        for (int [] mc :edges){
            edge[mc[0]].add(mc[1]);
            edge[mc[1]].add(mc[0]);
        }
        Queue<Integer> sd = new LinkedList<>();
        sd.add(src);
        while (!sd.isEmpty()){
            int s = sd.remove();
            if (!vis[s]){
                vis[s]=true;
                for (int i = 0; i <edge[s].size() ; i++) {
                    int d = edge[s].get(i);
                    if (ans[d]==-1){ans[d]=ans[s]+1;}
                    else{
                        ans[d]=Math.min(ans[d],ans[s]+1);
                    }
                    sd.add(d);
                }
            }

        }
        return ans;


    }
}
