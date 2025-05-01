package Runners;
import Structures.Maze;

import java.util.LinkedList;
import java.util.Queue;

public class BFSsan {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean bfs(Maze maze) {
        int endX = maze.getEnd()[0];
        int endY = maze.getEnd()[1];
        boolean[][] vis = new boolean[endX + 1][endY + 1];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // Out of bounds or not walkable
            if (!maze.isWalkable(p.x, p.y) || vis[p.x][p.y]) {
                continue;
            }

            vis[p.x][p.y] = true;

            // Check if reached end
            if (p.x == endX && p.y == endY) {
                return true;
            }

            // Add neighbors
            queue.add(new Point(p.x + 1, p.y));
            queue.add(new Point(p.x - 1, p.y));
            queue.add(new Point(p.x, p.y + 1));
            queue.add(new Point(p.x, p.y - 1));
        }

        return false;
    }
}

