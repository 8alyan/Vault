package leetcodeproblrms;

import java.util.*;

public class onezeronineone {
    public static  int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0]!=0||grid[grid.length-1][grid[0].length-1]!=0){return -1;}
        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] t : dist){
            Arrays.fill(t,Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] pair = pq.remove();
            int rs = pair[0];
            int cs = pair[1];
            if ((rs>0)){
                if(grid[rs-1][cs]==0&&dist[rs-1][cs]>pair[2]+1){
                dist[rs-1][cs]=pair[2]+1;
                pq.add(new int[]{rs-1,cs,pair[2]+1});}
                if ((cs>0)&&(grid[rs-1][cs-1]==0&&dist[rs-1][cs-1]>pair[2]+1)){
                    dist[rs-1][cs-1]=pair[2]+1;
                    pq.add(new int[]{rs-1,cs-1,pair[2]+1});
                }
            }
            if ((cs>0)){
                if (grid[rs][cs-1]==0&&dist[rs][cs-1]>pair[2]+1){
                dist[rs][cs-1]=pair[2]+1;
                pq.add(new int[]{rs,cs-1,pair[2]+1});}
                if ((rs<grid.length-1)&&(grid[rs+1][cs-1]==0&&dist[rs+1][cs-1]>pair[2]+1)){
                    dist[rs+1][cs-1]=pair[2]+1;
                    pq.add(new int[]{rs+1,cs-1,pair[2]+1});
                }
            }
            if ((rs<grid.length-1)){
                if (grid[rs+1][cs]==0&&dist[rs+1][cs]>pair[2]+1){
                dist[rs+1][cs]=pair[2]+1;
                pq.add(new int[]{rs+1,cs,pair[2]+1});}
                if ((cs<grid[0].length-1)&&(grid[rs+1][cs+1]==0&&dist[rs+1][cs+1]>pair[2]+1)){
                    dist[rs+1][cs+1]=pair[2]+1;
                    pq.add(new int[]{rs+1,cs+1,pair[2]+1});
                }
            }
            if ((cs<grid[0].length-1)){
                if ((grid[rs][cs+1]==0&&dist[rs][cs+1]>pair[2]+1)){
                dist[rs][cs+1]=pair[2]+1;
                pq.add(new int[]{rs,cs+1,pair[2]+1});}
                if ((rs>0)&&(grid[rs-1][cs+1]==0&&dist[rs-1][cs+1]>pair[2]+1)){
                    dist[rs-1][cs+1]=pair[2]+1;
                    pq.add(new int[]{rs-1,cs+1,pair[2]+1});
                }
            }
        }
        return dist[dist.length-1][dist[0].length-1]==Integer.MAX_VALUE?-1:dist[dist.length-1][dist[0].length-1];
    }

    public static int shortestPath(int[][] grid, int[] source, int[] destination) {

        if (grid[source[0]][source[1]]!=1||grid[destination[0]][destination[1]]!=1){return -1;}
        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] t : dist){
            Arrays.fill(t,Integer.MAX_VALUE);
        }
        dist[source[0]][source[1]]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        pq.add(new int[]{source[0],source[1],0});
        while(!pq.isEmpty()){
            int[] pair = pq.remove();
            int rs = pair[0];
            int cs = pair[1];
            if ((rs>0)){
                if(grid[rs-1][cs]==1&&dist[rs-1][cs]>pair[2]+1){
                    dist[rs-1][cs]=pair[2]+1;
                    pq.add(new int[]{rs-1,cs,pair[2]+1});}
                }
            if ((cs>0)){
                if (grid[rs][cs-1]==1&&dist[rs][cs-1]>pair[2]+1){
                    dist[rs][cs-1]=pair[2]+1;
                    pq.add(new int[]{rs,cs-1,pair[2]+1});}
            }
            if ((rs<grid.length-1)){
                if (grid[rs+1][cs]==1&&dist[rs+1][cs]>pair[2]+1){
                    dist[rs+1][cs]=pair[2]+1;
                    pq.add(new int[]{rs+1,cs,pair[2]+1});}
                }

            if ((cs<grid[0].length-1)){
                if ((grid[rs][cs+1]==1&&dist[rs][cs+1]>pair[2]+1)){
                    dist[rs][cs+1]=pair[2]+1;
                    pq.add(new int[]{rs,cs+1,pair[2]+1});}
            }
        }
        return dist[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:dist[destination[0]][destination[1]];
    }
    public static int minimumEffortPath(int[][] heights) {
        int[][] distance = new int[heights.length][heights[0].length];
        for (int[] g:distance){
            Arrays.fill(g,Integer.MAX_VALUE);
        }
        distance[0][0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] pair = pq.remove();
            int sr = pair[0];
            int sc = pair[1];
            if(sr>0){
                if(distance[sr-1][sc]>Math.max(Math.abs(heights[sr][sc]-heights[sr-1][sc]),distance[sr][sc])){
                    distance[sr-1][sc]=Math.max(Math.abs(heights[sr][sc]-heights[sr-1][sc]),distance[sr][sc]);
                    pq.add(new int[]{sr-1,sc,distance[sr-1][sc]});}
                }
            if (sc>0){
                if(distance[sr][sc-1]>Math.max(Math.abs(heights[sr][sc]-heights[sr][sc-1]),distance[sr][sc])){
                    distance[sr][sc-1]=Math.max(Math.abs(heights[sr][sc]-heights[sr][sc-1]),distance[sr][sc]);
                    pq.add(new int[]{sr,sc-1,distance[sr][sc-1]});}
            }
            if (sr<heights.length-1){
                if(distance[sr+1][sc]>Math.max(Math.abs(heights[sr+1][sc]-heights[sr][sc]),distance[sr][sc])){
                    distance[sr+1][sc]=Math.max(Math.abs(heights[sr+1][sc]-heights[sr][sc]),distance[sr][sc]);
                    pq.add(new int[]{sr+1,sc,distance[sr+1][sc]});}
            }
            if (sc<heights[0].length-1){
                if(distance[sr][sc+1]>Math.max(Math.abs(heights[sr][sc+1]-heights[sr][sc]),distance[sr][sc])){
                    distance[sr][sc+1]=Math.max(Math.abs(heights[sr][sc+1]-heights[sr][sc]),distance[sr][sc]);
                    pq.add(new int[]{sr,sc+1,distance[sr][sc+1]});}

            }
            }

        return distance[distance.length-1][distance[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(minimumEffortPath(new int[][]{{1,10,6,7,9,10,4,9}}));
        ArrayList<Integer> ans =new ArrayList<>();
        int csum = ans.getLast();
        for (int i = ans.size()-1; i >=0 ; i--) {
            if (ans.get(i)<csum){
                ans.remove(i);
            }else {csum=ans.get(i);}
        }
    }
}
