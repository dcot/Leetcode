package Gragh;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.MAX_VALUE/2;
            }
        }
        for (int i = 0; i < times.length; i++) {
            int from = times[i][0];
            int to = times[i][1];
            int cost = times[i][2];
            matrix[from - 1][to - 1] = cost;
        }
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE/2);
        dist[k - 1] = 0;

        for (int i = 0; i < n; i++) {
            int vertex = getMinIndex(dist, visited);
            if (vertex >= 0) {
                visited[vertex] = true;
                for (int j = 0; j < n; j++) {
                    dist[j] = Math.min(matrix[vertex][j]+dist[vertex],dist[j]);
                }
            }
        }
        Arrays.sort(dist);
        return dist[n - 1] == Integer.MAX_VALUE/2 ? -1 : dist[n-1];
    }

    public int getMinIndex(int[] dist, boolean[] visited) {
        int index = -1;
        int min = Integer.MAX_VALUE/2;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < min && !visited[i]) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}
