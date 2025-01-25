package leetcodeproblrms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class mst {
    static int spanningTree(int V, int E, int edges[][]){
        ArrayList<int[]>[] e = new ArrayList[V];
        for (int i = 0; i <V ; i++) {
            e[i]= new ArrayList<>();
        }
        for (int[] edge :edges){
            e[edge[0]].add(new int[]{edge[1],edge[2]});
            e[edge[1]].add(new int[]{edge[0],edge[2]});
        }
        boolean[] vis = new boolean[V];
        int ans =0;
        PriorityQueue<int[]> q   = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        q.add(new int[]{0,0,-1});
        while (!q.isEmpty()){
            int[] pair = q.remove();
            if (!vis[pair[1]]){
                vis[pair[1]]=true;
                if (pair[2]!=-1){ans+=pair[0];}
                for (int i = 0; i <e[pair[1]].size() ; i++) {
                    int d = e[pair[1]].get(i)[0];
                    int c = e[pair[1]].get(i)[1];
                    q.add(new int[]{c,d,pair[1]});
                }
            }
        }
        return ans;
    }
    public int minCostConnectPoints(int[][] points) {
        int[][] graph = new int[points.length][points.length];
        for (int i = 0; i <points.length; i++) {
            for (int j = i+1; j <points.length ; j++) {
                if (i!=j){
                    graph[i][j]=Math.abs(points[j][0]-points[i][0])+Math.abs(points[j][1]-points[i][1]);
                    graph[j][i]=graph[i][j];
                }
            }
        }
        int ans =0;
        boolean[] vis = new boolean[points.length];
        int[] cost =new int[points.length];
        Arrays.fill(cost,(int)1e9);
        cost[0]=0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        q.add(new int[]{0,0});
        while (!q.isEmpty()){
            int[] pair = q.remove();
            if (!vis[pair[1]]){
                ans+=pair[0];
                vis[pair[1]] = true;
                for (int i = 0; i <graph[pair[1]].length; i++) {
                    int d = i;
                    int c = graph[pair[1]][i];
                    if (!vis[d]&&i!=pair[1]&&cost[d]>c){
                        cost[d]=c;
                        q.add(new int[]{c,d});
                    }
                }

            }

        }
        return ans;
    }
    public static long maximumHappinessSum(int[] happiness, int k) {
        long ans =0;
        Arrays.sort(happiness);
        for (int i = happiness.length-1,z=0; i <=0&&k>0 ; i--,k--,z++) {
            ans+=happiness[i]-z;

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{42,12,1},3));
    }
}
