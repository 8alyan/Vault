package Runners;

import Structures.Maze;

public class DFSsan {


    public static  boolean dfs(Maze maze){
        boolean[][] vis = new boolean[maze.getEnd()[0]+1][maze.getEnd()[1]+1];
        return helper(0,0,maze,vis);
    }
    public static boolean helper(int i ,int j, Maze maze,boolean[][] vis){
        if(!maze.isWalkable(i,j)||vis[i][j]){return false;}
        vis[i][j]=true;
        if(maze.getEnd()[0]==i&&maze.getEnd()[1]==j){return true;}
        boolean a = helper(i+1,j,maze,vis);
        boolean b = helper(i-1,j,maze,vis);
        boolean c = helper(i,j-1,maze,vis);
        boolean d = helper(i,j+1,maze,vis);
        return a||b||c||d;
    }
}
