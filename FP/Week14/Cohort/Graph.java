package FP.Week14.Cohort;

import java.util.Arrays;

class Graph {
    private int[][] matrix;
    private int size;

    public Graph(int size) {
        this.size = size;
        matrix = new int[size][size];
        for (int[] row : matrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
    }

    public void addEdge(int vertex1, int vertex2, int value) {
        matrix[vertex1][vertex2] = value;
        matrix[vertex2][vertex1] = value;
    }

    // Method to return the adjacency matrix
    public int[][] getGraphMatrix() {
        return matrix;
    }
}
