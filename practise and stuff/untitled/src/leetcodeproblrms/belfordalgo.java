package leetcodeproblrms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class belfordalgo{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist,100000000);
        dist[S]=0;
        for (int i = 0; i <V-1 ; i++) {
            for (ArrayList<Integer> edge : edges) {
                int s = edge.get(0);
                int d = edge.get(1);
                int c = edge.get(2);
                if (dist[s] + c < dist[d]) {
                    dist[d] = dist[s] + c;
                }
            }
        }
        boolean b = false;
        for (ArrayList<Integer> edge : edges) {
            int s = edge.get(0);
            int d = edge.get(1);
            int c = edge.get(2);
            if (dist[s] + c < dist[d]) {
                b=true;
                dist[d] = dist[s] + c;
            }
        }
        if (b){Arrays.fill(dist,-1);}
        return dist;


    }
    public  static int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;
        for (int i = 0;i<n-1; i++) {
            for (int[] t:times){
                int s = t[0]-1;
                int d = t[1]-1;
                int c = t[2];
                if (dist[s]!=Integer.MAX_VALUE&&dist[s]+c<dist[d]){
                    dist[d]=dist[s]+c;
                }
            }
        }
        int m =0;
        for(int z :dist){
            m=Math.max(m,z);
            if (z==Integer.MAX_VALUE){return -1;}
        }
        return m;
    }
    public String[] findRelativeRanks(int[] score) {
        int[] scr = Arrays.copyOf(score,score.length);
        String[] ans = new String[score.length];
        Arrays.sort(scr);
        Map<Integer,String> mp = new HashMap<>();
        int start = scr.length;
        for (int i = scr.length-1; i >=0 ; i--) {
            if (start-i<4){
                if (start-i==1){mp.put(scr[i],"Gold Medal");}
                else if (start-i==2){mp.put(scr[i],"Silver Medal");}
                else {mp.put(scr[i],"Bronze Medal");}
            }
            else {
                mp.put(scr[i],Integer.toString(start-i));
            }
        }
        for (int i = 0; i <score.length ; i++) {
            ans[i]=mp.get(score[i]);
        }
        return ans;
    }

    public void shortest_distance(int[][] matrix) {
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if (matrix[i][j]==-1){matrix[i][j]=(int)1e9;}
                if (i==j){matrix[i][j]=0;}
            }
        }
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix.length ; j++) {
                for (int k = 0; k <matrix[0].length ; k++) {
                    matrix[j][k]=Math.min(matrix[j][k],matrix[j][i]+matrix[i][k]);
                }
            }
        }
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if (matrix[i][j]==(int)1e9){matrix[i][j]=-1;}
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{1,2,1},{2,1,3}
        },2,2));

    }
}
