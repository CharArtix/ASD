package FP.Week14.Cohort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // task1();
        // task2();
        optionalTask();
    }

    public static void task1() {
        // Section 4: 5 mennit
        // read file input
        Scanner sc = new Scanner(Main.class.getResourceAsStream("deliveryboy.txt"));

        // Input jumlah streets
        int N = sc.nextInt();

        // Section 5: 5 menit (maks. 10 menit)
        // Input matriks jarak antarjalan NxN
        int[][] T = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                T[i][j] = sc.nextInt();
            }
        }

        // Input jumlah skenario
        int M = sc.nextInt();

        // Proses semua skenario
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt(); // Restoran
            int G = sc.nextInt(); // Gas station
            int D = sc.nextInt(); // Destination

            // Simpan semua jarak dari jalan S
            int[] distanceS = Delivery.djikstra(T, S);
            // hotung jarak restoran -> gas station
            int distSG = distanceS[G];
            // hitung jarak gas station -> destination
            int[] distanceG = Delivery.djikstra(T, G);
            int distGD = distanceG[D];
            // hitung jarak original = S -> G -> D
            int jarakOriginal = distGD + distSG;

            // Hitung jarak optimal = S -> D
            int jarakOptimal = distanceS[D];

            // Output hasil
            System.out.println(jarakOriginal + " " + (jarakOriginal - jarakOptimal));
        }
    }

    public static void task2() {
        String[] labels = { "A", "B", "C", "D", "E", "F", "G" };
        Graph graph = new Graph(labels.length);

        // Add edges with weights
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 15);
        graph.addEdge(1, 3, 12);
        graph.addEdge(1, 5, 15);
        graph.addEdge(2, 5, 10);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 6, 5);
        graph.addEdge(5, 6, 5);

        TravelPlan tp = new TravelPlan();
        tp.cheapestRoute(graph.getGraphMatrix(), labels, 0);
    }

    public static void optionalTask() {
        // Create the weighted graph
        WeightedGraphAL graph = new WeightedGraphAL();

        // Add the edges to the graph
        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 2);
        graph.addEdge("A", "D", 8);
        graph.addEdge("B", "E", 8);
        graph.addEdge("B", "G", 10);
        graph.addEdge("C", "D", 5);
        graph.addEdge("C", "F", 8);
        graph.addEdge("D", "G", 7);
        graph.addEdge("E", "H", 7);
        graph.addEdge("F", "I", 10);
        graph.addEdge("G", "H", 10);
        graph.addEdge("G", "I", 3);
        graph.addEdge("H", "I", 5);

        // Print the adjacency list representation of the graph
        System.out.println("Weighted Graph Adjacency List:");
        System.out.println(graph);

        // Find the shortest path from A to H using Dijkstra's algorithm
        graph.dijkstra("A", "H");
    }

}
