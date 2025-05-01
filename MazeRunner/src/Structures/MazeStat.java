package Structures;

public class MazeStat {
    public int steps = 0;
    public int wallHits = 0;
    public int boundaryHits = 0;
    public long timeTaken = 0;

    public void printStats() {
        System.out.println("Steps: " + steps);
        System.out.println("Wall Hits: " + wallHits);
        System.out.println("Boundary Hits: " + boundaryHits);
        System.out.println("Time (ms): " + timeTaken);
    }
}
