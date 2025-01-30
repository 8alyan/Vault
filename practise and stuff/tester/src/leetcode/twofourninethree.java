package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class twofourninethree {
    public int magnificentSets(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] group = new int[n+1];
        for(int i =0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        for(int [] e :edges){
            int s= e[0];
            int d= e[1];
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
        if(isbi(graph)){return -1;}
        int ans=0;
        for(int i =1;i<=n;i++){
            boolean[] vis = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            int level =0;
            while(!q.isEmpty()){
                int r = q.size();
                for(int j =0;j<r;j++){
                    int s = q.remove();
                    vis[s]=true;
                    for(int k =0;k<graph.get(s).size();k++){
                        int d = graph.get(s).get(k);
                        if(!vis[d]){
                            q.add(d);
                           
                        }
                    }
                }
                level++;
            }
            ans=Math.max(ans,level);
        }
        return ans;
    }
    public boolean isbi(ArrayList<ArrayList<Integer>> graph){
        int n = graph.size();
        int[] colour = new int[n];
        Queue<Integer> q= new LinkedList<>();
        q.add(1);
        int level =1;
        while(!q.isEmpty()){
            int r = q.size();
            for(int i =0;i<r;i++){
                int s = q.remove();
                colour[s]=level;
                for(int j =0;j<graph.get(s).size();j++){
                    int d = graph.get(s).get(j);
                    if(colour[d]!=0&&colour[d]==colour[s]){return true;}
                    else if(colour[d]==0){q.add(d);}
                }
            }
            if(level==1){level=2;}
            else{level=1;}
        }
        return false;
    }

    public static void main(String[] args) {
        twofourninethree k = new twofourninethree();
        int[][] array = {
                {67, 29}, {13, 29}, {77, 29}, {36, 29}, {82, 29}, {54, 29}, {57, 29}, {53, 29},
                {68, 29}, {26, 29}, {21, 29}, {46, 29}, {41, 29}, {45, 29}, {56, 29}, {88, 29},
                {2, 29}, {7, 29}, {5, 29}, {16, 29}, {37, 29}, {50, 29}, {79, 29}, {91, 29},
                {48, 29}, {87, 29}, {25, 29}, {80, 29}, {71, 29}, {9, 29}, {78, 29}, {33, 29},
                {4, 29}, {44, 29}, {72, 29}, {65, 29}, {61, 29}
        };
        System.out.println(k.magnificentSets(92,array));
    }
}
