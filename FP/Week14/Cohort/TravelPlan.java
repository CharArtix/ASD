package FP.Week14.Cohort;

import java.util.*;

class TravelPlan {
    public void cheapestRoute(int[][] graphMatrix, String[] Labelz, int start) {
        int size = graphMatrix.length;
        int[] distances = new int[size];
        boolean[] visited = new boolean[size];
        int[] previous = new int[size];
        
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        distances[start] = 0;

        PriorityQueue<int[]> FChoice = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        FChoice.add(new int[] {start, 0});

        while (!FChoice.isEmpty()) {
            int[] current = FChoice.poll();
            int currentNode = current[0];
            if (visited[currentNode]) continue;

            visited[currentNode] = true;

            for (int tetangga = 0; tetangga < size; tetangga++) {
                if (graphMatrix[currentNode][tetangga] != Integer.MAX_VALUE) {
                    int jarak = distances[currentNode] + graphMatrix[currentNode][tetangga];
                    if (jarak < distances[tetangga]) {
                        distances[tetangga] = jarak;
                        previous[tetangga] = currentNode;
                        FChoice.add(new int[] {tetangga, jarak});
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (i == start) {
                System.out.println("Path: " + Labelz[start]); 
                System.out.println("Cost: 0");
                continue;
            }
            System.out.println("Path: " + reconstructPath(previous, Labelz, start, i));
            System.out.println("Cost: " + distances[i]);
        }
    }

    private String reconstructPath(int[] previous, String[] Labelz, int start, int end) {
        List<String> path = new ArrayList<>();
        for (int at = end; at != -1; at = previous[at]) {
            path.add(Labelz[at]);
        }
        Collections.reverse(path);
        return String.join(" --> ", path);
    }
}

