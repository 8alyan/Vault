package leetcodeproblrms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class onefiveonefour {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<double[]>> edge = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            edge.add(new ArrayList<>());
        }
        for (int i = 0; i <edges.length ; i++) {
            edge.get(edges[i][0]).add(new double[]{edges[i][1],succProb[i]});
            edge.get(edges[i][1]).add(new double[]{edges[i][0],succProb[i]});
        }
        double[] prob = new double[n];
        prob[start_node]=1;
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble((double[] o)->o[0]).reversed());
        pq.add(new double[]{start_node,1});
        while (!pq.isEmpty()){
            double[] latest = pq.poll();
            int s =(int)latest[0];
            for (double[] e : edge.get(s)){
                int d = (int)(e[0]);
                if (prob[d]<prob[s]*e[1]){
                    prob[d]=prob[s]*e[1];
                    pq.add(new double[]{d,prob[d]});
                }
            }
        }
        return prob[end_node];
    }
}
