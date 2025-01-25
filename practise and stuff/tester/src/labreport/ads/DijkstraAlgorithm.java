package labreport.ads;

import java.util.*;

class DijkstraAlgorithm {

    // Method to find the vertex with the minimum distance
    private static int getMinDistanceVertex(int[] distances, boolean[] visited, int vertices) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    // Dijkstra's Algorithm
    public static void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        int[] distances = new int[vertices]; // Shortest distances from the source
        boolean[] visited = new boolean[vertices]; // Visited vertices

        // Initialize distances to infinity and visited to false
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int currentVertex = getMinDistanceVertex(distances, visited, vertices);
            visited[currentVertex] = true;

            // Update distances of adjacent vertices
            for (int neighbor = 0; neighbor < vertices; neighbor++) {
                if (!visited[neighbor] &&
                    graph[currentVertex][neighbor] != 0 &&
                    distances[currentVertex] != Integer.MAX_VALUE &&
                    distances[currentVertex] + graph[currentVertex][neighbor] < distances[neighbor]) {
                    distances[neighbor] = distances[currentVertex] + graph[currentVertex][neighbor];
                }
            }
        }

        // Print the shortest distances
        System.out.println("Vertex \t Shortest Distance from Source " + source);
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t\t " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0},
            {4, 0, 8, 0, 0, 0},
            {0, 8, 0, 7, 0, 4},
            {0, 0, 7, 0, 9, 14},
            {0, 0, 0, 9, 0, 10},
            {0, 0, 4, 14, 10, 0}
        };

        int source = 0; // Starting vertex
        dijkstra(graph, source);
    }
}
