package leetcodeproblrms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ninethreeone {
    public static int minFallingPathSum(int[][] matrix) {
        int rs = matrix.length;
        int cs = matrix[0].length;
        for (int i = rs-2; i>=0 ; i--) {
            for (int j = 0; j <cs ; j++) {
                int min =Integer.MAX_VALUE;
                for (int k =0; k <cs ; k++) {
                    if (k==j){continue;}
                    min=Math.min(min,matrix[i+1][k]);
                }
                matrix[i][j]+=min;

            }
        }
        int low =Integer.MAX_VALUE;
        for (int i = 0; i <cs ; i++) {
            if (matrix[0][i]<low){
                low =matrix[0][i];
            }
        }
        return low;

    }

    public  static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        boolean[] vis = new boolean[numCourses];
        ArrayList<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i <numCourses ; i++) {
            edges[i]= new ArrayList<>();
        }
        for (int[] p:prerequisites){
            edges[p[1]].add(p[0]);
        }
        Stack<Integer> sd = new Stack<>();
        for (int i = 0; i <numCourses; i++) {
            if (!vis[i]){
               if(!helper(sd,edges,i,vis,new boolean[numCourses])){return new int[]{};}
            }
        }
        int size = sd.size();
        for (int i = 0; i <size ; i++) {
            ans[i]=sd.pop();
        }
        return ans;
    }

    private static boolean helper(Stack<Integer> sd, ArrayList<Integer>[] edges, int i,boolean[] vis,boolean[] sti) {
        if (sti[i]){return false;}
        if(vis[i]){return true;}
        vis[i]=true;
        sti[i]=true;
        for (int j = 0; j <edges[i].size() ; j++) {
            if(!helper(sd,edges,edges[i].get(j),vis,sti)){return false;}
        }
        sd.add(i);
        sti[i]=false;
        return true;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
    }
}
