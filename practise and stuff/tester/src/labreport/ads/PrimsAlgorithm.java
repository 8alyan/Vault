package labreport.ads;

import java.util.*;

class PrimsAlgorithm {

    // Function to find the vertex with the minimum key value
    private static int getMinKeyVertex(int[] key, boolean[] included, int vertices) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!included[i] && key[i] < minValue) {
                minValue = key[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    // Prim's Algorithm
    public static void primMST(int[][] graph) {
        int vertices = graph.length;
        int[] parent = new int[vertices]; // To store the MST
        int[] key = new int[vertices];   // To store minimum weights
        boolean[] included = new boolean[vertices]; // Tracks included vertices

        // Initialize keys to infinity and included[] to false
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;        // Start from the first vertex
        parent[0] = -1;    // First node is the root of the MST

        for (int i = 0; i < vertices - 1; i++) {
            int u = getMinKeyVertex(key, included, vertices); // Pick minimum key vertex
            included[u] = true;

            // Update key values and parent index for adjacent vertices
            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !included[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the MST
        printMST(parent, graph);
    }

    // Function to print the MST
    private static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        primMST(graph);
    }
}
