package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class ninefeb {
    public int[][] sortMatrix(int[][] grid) {
        for (int i = 0; i < grid.length ; i++) {
            ArrayList<Integer> eh = new ArrayList<>();
            int j =0;
            int l =i;
            while(l< grid.length&&j<grid[0].length){
                eh.add(grid[l][j]);
                j++;l++;
            }
            Collections.sort(eh);
            l=i;j=0;
            while(l< grid.length&&j<grid[0].length){
                grid[l][j]=eh.removeLast();
                j++;l++;
            }
        }
        for (int j = 1; j < grid[0].length ; j++) {
            ArrayList<Integer> eh = new ArrayList<>();
            int i =0;
            int l =j;
            while(i< grid.length&&l<grid[0].length){
                eh.add(grid[i][l]);
                l++;i++;
            }
            Collections.sort(eh);
            i=0;l=j;
            while(i< grid.length&&l<grid[0].length){
                grid[i][l]=eh.removeLast();
                l++;i++;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        ninefeb n = new ninefeb();
        int[][] grid = new int[][]{{1,7,3},{9,8,2},{4,5,6}};
        n.sortMatrix(grid);
    }
}
