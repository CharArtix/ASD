package FP.Week14.Cohort;

import java.util.*;

// WeightedGraphAL Class
public class WeightedGraphAL {
    // Adjacency List to represent the graph
    private Map<String, List<Edge>> adjacencyList;

    // Constructor to initialize the adjacency list
    public WeightedGraphAL() {
        this.adjacencyList = new HashMap<>();
    }

    // Method to add a weighted edge between two nodes
    public void addEdge(String node1, String node2, int weight) {
        // Add the edge from node1 to node2
        if (!adjacencyList.containsKey(node1)) {
            adjacencyList.put(node1, new ArrayList<>());
        }
        adjacencyList.get(node1).add(new Edge(node2, weight));

        // Add the edge from node2 to node1 (since the graph is undirected)
        if (!adjacencyList.containsKey(node2)) {
            adjacencyList.put(node2, new ArrayList<>());
        }
        adjacencyList.get(node2).add(new Edge(node1, weight));
    }

    // Method to print the adjacency list representation of the graph
    @Override
    public String toString() {
        StringBuilder StriBul = new StringBuilder();
        for (Map.Entry<String, List<Edge>> entry : adjacencyList.entrySet()) {
            StriBul.append(entry.getKey()).append(" --> ");
            for (Edge edge : entry.getValue()) {
                StriBul.append(edge.getTargetNode()).append("(").append(edge.getWeight()).append(") ");
            }
            StriBul.append("\n");
        }
        return StriBul.toString();
    }

    // Method to implement Dijkstra's algorithm
    public void dijkstra(String start, String end) {
        // Create a priority queue to store the nodes
        PriorityQueue<Node> Prique = new PriorityQueue<>((a, b) -> a.getDistance() - b.getDistance());
    
        // Create a map to store the distance of each node from the start
        Map<String, Node> distanceMap = new HashMap<>();
    
        // Create a map to store the previous node for path reconstruction
        Map<String, String> previousMap = new HashMap<>();
    
        // Initialize the start node with distance 0
        Node startNode = new Node(start, 0);
        Prique.offer(startNode);
        distanceMap.put(start, startNode);
        previousMap.put(start, null); // Start node has no predecessor
    
        while (!Prique.isEmpty()) {
            Node currentNode = Prique.poll();
    
            // If we've reached the end node, print the path and distance
            if (currentNode.getNode().equals(end)) {
                System.out.print("Path: ");
                printPath(previousMap, end);
                System.out.println("\nShortest Distance from " + start + " to " + end + " == " + currentNode.getDistance());
                return;
            }
    
            // Update the distances of the neighboring nodes
            for (Edge edge : adjacencyList.getOrDefault(currentNode.getNode(), new ArrayList<>())) {
                String neighbor = edge.getTargetNode();
                int weight = edge.getWeight();
                int distance = currentNode.getDistance() + weight;
    
                if (!distanceMap.containsKey(neighbor) || distance < distanceMap.get(neighbor).getDistance()) {
                    Node neighborNode = new Node(neighbor, distance);
                    Prique.offer(neighborNode);
                    distanceMap.put(neighbor, neighborNode);
                    previousMap.put(neighbor, currentNode.getNode()); // Track the predecessor
                }
            }
        }
    
        // If we reach this point, there is no path from the start to the end
        System.out.println("No path found from " + start + " to " + end);
    }
    


    // Helper method to print the shortest path
    private void printPath(Map<String, String> previousMap, String current) {
        if (current == null) {
            return;
        }
        printPath(previousMap, previousMap.get(current)); // Recursively print the previous nodes
        System.out.print(current + " ");
    }
    
}
