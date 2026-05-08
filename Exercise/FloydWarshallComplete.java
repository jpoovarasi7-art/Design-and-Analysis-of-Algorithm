import java.util.Scanner;
public class FloydWarshallComplete {
    static final int INF = 100000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        int[][] dist = new int[V][V];
        int[][] parent = new int[V][V];
        System.out.println("\nEnter the distance matrix (Use 100000000 for INF):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = sc.nextInt();
                if (i != j && dist[i][j] != INF) {
                    parent[i][j] = i;
                } else {
                    parent[i][j] = -1;
                }
            }
        }
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            parent[i][j] = parent[k][j];
                        }
                    }
                }
            }
        }
        System.out.println("\nShortest Distance Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) System.out.print("INF\t");
                else System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\nPath Reconstruction:");
        System.out.print("Enter source node: ");
        int src = sc.nextInt();
        System.out.print("Enter destination node: ");
        int dest = sc.nextInt();
        printPath(parent, src, dest);
        sc.close();
    }
    public static void printPath(int[][] parent, int i, int j) {
        if (i == j) {
            System.out.println("Path: " + i);
            return;
        }
        if (parent[i][j] == -1) {
            System.out.println("No path exists.");
            return;
        }
        String path = String.valueOf(j);
        int curr = j;
        while (curr != i) {
            curr = parent[i][curr];
            path = curr + " -> " + path;
        }
        System.out.println("Shortest Path: " + path);
    }
}
