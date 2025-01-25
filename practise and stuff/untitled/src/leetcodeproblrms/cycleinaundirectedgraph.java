package leetcodeproblrms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//is code m graph p cycle check karein hain by both dfs and bfs and undirected is the simpler one you only need to check parent condition and after that is the node that are you visiting is already visited then cycle exist
public class cycleinaundirectedgraph {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i <V ; i++) {
            if (!vis[i]){

                if(dfs(adj,i,vis,new boolean[V],-1)){return true;}
            }
        }
        return false;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj,int i, boolean[] vis, boolean[] stack, int parent) {
        vis[i]=true;
        for (int j = 0; j <adj.get(i).size(); j++) {
            int d = adj.get(i).get(j);
            if(d==parent){continue;}
            if (vis[d]){return true;}
            else{
                if (dfs(adj,d,vis,stack,i)){return true;}
            }

        }
        return false;

    }

    private boolean bfs(ArrayList<ArrayList<Integer>> adj, int v, int i, boolean[] vis) {
        Queue<int[]> kyu = new LinkedList<>();
        kyu.add(new int[]{i,-1});
        while (!kyu.isEmpty()){
            int[] c = kyu.poll();
            if (!vis[c[0]]){
                vis[c[0]]=true;
                for (int j = 0; j <adj.get(c[0]).size() ; j++) {
                    int d =adj.get(c[0]).get(j);
                    if (d==c[1]){continue;}
                    if (vis[d]){return true;}
                    kyu.add(new int[]{d,c[0]});
                }
            }else {return true;}
        }
        return false;
    }

}
