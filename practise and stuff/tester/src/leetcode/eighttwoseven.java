package leetcode;

import java.util.LinkedList;
import java.util.Queue;
class DisJoint{
    int[][] size;
    int[][][] parent;
    DisJoint(int n,int[][] grid){
        size = new int[n][n];
        parent = new int[n][n][2];
        for(int i =0;i<n;i++){
            for (int j = 0; j <n; j++) {
                size[i][j]=grid[i][j];
                parent[i][j]=new int[]{i,j};
            }
        }
    }
    public boolean joinbysize(int[] i,int[] j){
        int[] ip= uparent(i);
        int[] jp= uparent(j);
        if(ip[0]==jp[0]&&ip[1]==jp[1]){return false;}
        else{
            int s= size[ip[0]][ip[1]]+size[jp[0]][jp[1]];
            if(size[ip[0]][ip[1]]>size[jp[0]][jp[1]]){
                parent[jp[0]][jp[1]]=new int[]{ip[0],ip[1]};
                size[ip[0]][ip[1]]=s;
            }else{
                parent[ip[0]][ip[1]]=new int[]{jp[0],jp[1]};
                size[jp[0]][jp[1]]=s;
            }

        }
        return true;
    }
    public int[] uparent(int[] i){
        if((i[0]<0||i[0]>=size.length)||(i[1]<0||i[1]>=size.length)){return new int[]{-1,-1};}
        int[] p =i;
        while(parent[i[0]][i[1]][0]!=i[0]||parent[i[0]][i[1]][1]!=i[1]){
            i=new int[]{parent[i[0]][i[1]][0],parent[i[0]][i[1]][1]};
        }
        parent[p[0]][p[1]]=new int[]{i[0],i[1]};
        return i;
    }
    public int maybe(int[] i,int[] j,int [] k,int[] l){
       int[] ui = uparent(i);
       int[] uj =uparent(j);
       int[] uk = uparent(k);
       int[] ul = uparent(l);
       int ans =ui[0]==-1||ui[1]==-1?0:size[ui[0]][ui[1]];
       if(uj[0]!=ui[0]||uj[1]!=ui[1]){ans+=uj[0]==-1||uj[1]==-1?0:size[uj[0]][uj[1]];}
       if((uk[0]!=ui[0]||uk[1]!=ui[1])&&(uj[0]!=uk[0]||uj[1]!=uk[1])){ans+=uk[0]==-1||uk[1]==-1?0:size[uk[0]][uk[1]];}
       if((ul[0]!=ui[0]||ul[1]!=ui[1])&&(ul[0]!=uk[0]||ul[1]!=uk[1])&&(ul[0]!=uj[0]||ul[1]!=uj[1])){ans+=ul[0]==-1||ul[1]==-1?0:size[ul[0]][ul[1]];}
       return ans+1;
    }
}

public class eighttwoseven {

    public int largestIsland(int[][] grid) {
        int ans =0;
        DisJoint set = new DisJoint(grid.length,grid);
        boolean[][] vis = new boolean[grid.length][grid.length];
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j <grid.length ; j++) {
                if(grid[i][j]==1&&!vis[i][j]){
                    helper(grid,vis,new int[]{i,j},set);
                }
            }
        }
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid.length ; j++) {
                if(grid[i][j]==0){

                   ans=Math.max(ans, set.maybe(new int[]{i+1,j},new int[]{i-1,j},new int[]{i,j-1},new int[]{i,j+1}));
                }
            }
        }
        if(ans==0){return grid.length*grid.length;}
        return ans;
    }
    public void helper(int[][] grid, boolean[][] vis, int[] r, DisJoint set){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(r);
        int area=0;
        while(!queue.isEmpty()){
            int[] temp = queue.remove();
            int i = r[0];
            int j = r[1];
            if(vis[i][j]){continue;}
            vis[i][j]=true;
            if(i>0&&grid[i-1][j]==1){set.joinbysize(temp,new int[]{i-1,j});queue.add(new int[]{i-1,j});}
            if(j>0&&grid[i][j-1]==1){set.joinbysize(temp,new int[]{i,j-1});queue.add(new int[]{i,j-1});}
            if(j< grid.length-1&&grid[i][j+1]==1){set.joinbysize(temp,new int[]{i,j+1});queue.add(new int[]{i,j+1});}
            if(i< grid.length-1&&grid[i+1][j]==1){set.joinbysize(temp,new int[]{i+1,j});queue.add(new int[]{i+1,j});}
        }
    }

    public static void main(String[] args) {
        eighttwoseven s = new eighttwoseven();
        int[][] array = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}
        };
        System.out.println(s.largestIsland(array));
    }
}
