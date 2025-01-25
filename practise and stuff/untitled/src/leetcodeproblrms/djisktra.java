package leetcodeproblrms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class djisktra {
    static class pair implements Comparable<pair>{
        int a;
        int b;
        pair(int a1, int b1){
            this.a=a1;
            this.b=b1;
        }

        @Override
        public int compareTo(pair o) {
            return this.b-o.b;
        }
    }
    public static void main(String[] args) {
       djiksta();




    }

    private static void djiksta() {
        ArrayList<pair> graph[] = new ArrayList[7];
        boolean vis[]= new boolean[7];
        int[] distance = new int[7];
        Arrays.fill(distance,Integer.MAX_VALUE);
        creatinggraph(graph);
        distance[0]=0;
        PriorityQueue<pair> d = new PriorityQueue<>();
        d.add(new pair(0,0));
        while(!d.isEmpty()){
            pair s = d.remove();
            if (!vis[s.a]){
                vis[s.a]=true;
                for (int i = 0; i <graph[s.a].size() ; i++) {
                    pair edge = graph[s.a].get(i);
                    int dest = edge.a;
                    int weight = edge.b;
                    if (s.b+weight<distance[dest]){
                        distance[dest]=s.b+weight;
                        d.add(new pair(dest,distance[dest]));
                    }
                }
            }
        }
        for (int m : distance){
            System.out.print(m+" ");
        }
        System.out.println();
    }

    private static void creatinggraph(ArrayList<pair>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new pair(1,1));
        graph[0].add(new pair(2,3));
        graph[0].add(new pair(6,2));

        graph[1].add(new pair(2,1));
        graph[1].add(new pair(3,5));
        graph[1].add(new pair(4,1));

        graph[2].add(new pair(4,1));
        graph[2].add(new pair(3,2));

        graph[3].add(new pair(4,3));

        graph[4].add(new pair(5,4));

        graph[5].add(new pair(6,1));





    }
}
