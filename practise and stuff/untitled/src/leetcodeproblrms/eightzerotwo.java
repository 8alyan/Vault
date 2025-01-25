package leetcodeproblrms;

import java.util.*;

public class eightzerotwo {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer>[] edges = new ArrayList[graph.length];
        for (int i = 0; i < edges.length ; i++) {
            edges[i]=new ArrayList<>();
        }
        int[] outdegree = new int[graph.length];
        for (int i = 0; i < graph.length ; i++) {
            for (int j = 0; j <graph[i].length ; j++) {
                outdegree[i]= graph[i].length;
                edges[graph[i][j]].add(i);
            }
        }
        Stack<Integer> sd = new Stack<>();
        for (int i = 0; i < outdegree.length; i++) {
            if (outdegree[i]==0){
                sd.add(i);
            }
        }
        while(!sd.isEmpty()){
            int n =sd.pop();
            ans.add(n);
            for (int i = 0; i <edges[n].size() ; i++) {
                int p = edges[n].get(i);
                outdegree[p]--;
                if (outdegree[p]==0){
                    sd.add(p);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }


    public static void main(String[] args) {
        eightzerotwo t = new eightzerotwo();

    }
}
