package leetcodeproblrms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class articulationviatarzan {
    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>> edges)
    {
        int[] insertion = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        Set<Integer> df = new HashSet<>();
        for (int i = 0; i <n ; i++) {
            if (!vis[i]){
                dfs(edges,df,insertion,low,vis,i,0,-1,i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(df);
        ans.sort(Comparator.comparingInt(a->a));
        if(ans.isEmpty()){ans.add(-1);}
        return ans;


    }
    private void dfs(ArrayList<ArrayList<Integer>> edges, Set<Integer> ans, int[] insertion, int[] low, boolean[] vis, int i, int z, int p, int sp ) {
        if (vis[i]){return;}
        vis[i]=true;
        insertion[i]=z;
        low[i]=z;
        int r = 0;
        for (int j : edges.get(i)) {
            if (j==p){continue;}
            if (!vis[j]){
                if(i==sp){r++;}
                dfs(edges,ans,insertion,low,vis, j,z+1,i,sp);
                low[i]=Math.min(low[i],low[j]);
                if (low[j]>=insertion[i]&&p!=-1){
                    ans.add(i);
                }
            }
            else{
                low[i]=Math.min(low[i],insertion[j]);
            }
        }
        if(r>1){ans.add(i);}
    }
}
