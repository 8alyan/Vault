package leetcodeproblrms;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class seventhreethree {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int og = image[sr][sc];
       // dfs(image,sr,sc,color,og);
        bfs(image,sr,sc,color,og);
        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int color,int og) {
        Queue<int[]> g = new LinkedList<>();
        g.add(new int[]{sr,sc});
        while(!g.isEmpty()){
            int[] pair = g.remove();
            if (image[pair[0]][pair[1]]==og){
                image[pair[0]][pair[1]]=color;
                if (pair[0]>0){g.add(new int[]{pair[0]-1,pair[1]});}
                if (pair[0]<image.length-1){g.add(new int[]{pair[0]+1,pair[1]});}
                if (pair[1]>0){g.add(new int[]{pair[0],pair[1]-1});}
                if (pair[1]<image[0].length-1){g.add(new int[]{pair[0],pair[1]+1});}

            }
        }

    }

    private void dfs(int[][] image, int sr, int sc, int color,int og) {
        if(image[sr][sc]==color||image[sr][sc]!=og){return;}
        image[sr][sc]=color;
        if (sr>0){dfs(image,sr-1,sc,color,og);}
        if (sr<image.length-1){dfs(image,sr+1,sc,color,og);}
        if (sc>0){dfs(image,sr,sc-1,color,og);}
        if (sc<image[0].length-1){dfs(image,sr,sc+1,color,og);}

    }

    public static void main(String[] args) {
        seventhreethree t = new seventhreethree();
        for (int[] n:t.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2)){
            System.out.println(Arrays.toString(n));
        }
    }
}
