package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class twofivesevenseven {
//    public int minimumTime(int[][] grid) {
//        int[][] dj = new int[grid.length][grid[0].length];
//        for(int[] m :dj){Arrays.fill(m,(int)(1e9));}
//        dj[0][0]=0;
//        if(grid[0][1]!=1&&grid[1][0]!=1){return -1;}
//        djik(dj,grid);
//        return dj[grid.length-1][grid[0].length-1];
//    }

//    private void djik(int[][] dj, int[][] grid) {
//        int n = dj.length;
//        int m = dj[0].length;
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p->p[2]));
//        pq.add(new int[]{0,0,0});
//        while (!pq.isEmpty()){
//            int[] temp = pq.poll();
//            int i = temp[0];
//            int j = temp[1];
//            int t = temp[2];
//            if(i<n-1){
//                //down
//            }
//            if(i>0){
//                //up
//            }
//            if (j<m-1){
//                //left
//            }
//            if(j>0){
//                //right
//            }
//        }
//    }
}
