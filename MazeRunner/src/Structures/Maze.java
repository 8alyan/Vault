package Structures;


import Runners.BFSsan;
import Runners.DFSsan;

public class Maze {
    private int[][] grid;
    private int rows, cols;
    private int[] start = {0, 0};
    private int[] end;
    private MazeStat stat=new MazeStat();


    public Maze(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.end = new int[]{rows - 1, cols - 1};
    }

    public int[][] getGrid() {
        return grid;
    }

    public int[] getStart() {
        return start;
    }

    public int[] getEnd() {
        return end;
    }
    public boolean isInsideMaze(int row, int col) {
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }

    public boolean isWalkable(int row, int col) {
        if(!isInsideMaze(row, col)){stat.boundaryHits++;return false;}
        if(grid[row][col] == 1){stat.wallHits++;return false;}
         stat.steps++;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 1, 1},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0}
        };
        Maze m = new Maze(grid);
        System.out.println(DFSsan.dfs(m));
        Maze k = new Maze(grid);
        BFSsan.bfs(k);
        k.stat.printStats();
        m.stat.printStats();

    }
}
