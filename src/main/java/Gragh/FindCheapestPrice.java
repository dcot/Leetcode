package Gragh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCheapestPrice {
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        int[][] dist = new int[n][n];
//        int[][] graph = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                graph[i][j] = dist[i][j] = Integer.MAX_VALUE/2;
//                if (i == j) graph[i][j] = 0;
//            }
//        }
//        dist[0][src] = 0;
//
//
//        for (int[] flight : flights) {
//            int from = flight[0];
//            int to = flight[1];
//            int cost = flight[2];
//            graph[from][to] = cost;
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                List<Integer> fromPoints = getFromPoints(graph, j, n);
//                for (int fromPoint : fromPoints) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i-1][fromPoint] + graph[fromPoint][j]);
//                }
//            }
//        }
//        if (k+1 >= n) k = n-2;
//        return dist[k+1][dst] >= (Integer.MAX_VALUE/2) ? -1 : dist[k+1][dst];
//    }
//    public List<Integer> getFromPoints(int[][] graph, int toPoint, int n) {
//        List<Integer> fromPoints = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (graph[i][toPoint] < (Integer.MAX_VALUE/2)) {
//                fromPoints.add(i);
//            }
//        }
//        return fromPoints;
//    }
    /*
    滚动数组优化解法，只需要最下面两行数组就行了，不用申请n*n的空间
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int inf = Integer.MAX_VALUE / 2;
        int[] previous = new int[n];
        int[] current = new int[n];
        Arrays.fill(previous, inf);
        Arrays.fill(current, inf);
        previous[src] = 0;

        for (int i = 1; i < k + 2; i++) {
            current[src] = 0;
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                if (previous[from] < inf) {
                    current[to] = Math.min(current[to], previous[from] + cost);
                }
            }
            previous = current.clone();
        }
        return current[dst] == inf ? -1 : current[dst];
    }
}
