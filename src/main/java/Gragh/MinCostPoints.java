package Gragh;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostPoints {
    class UnionFind {
        private int[] roots;
        private int[] rank; //存储高度

        public UnionFind(int size) {
            this.roots = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                this.roots[i] = i;
                this.rank[i] = 1;
            }
        }

        //路径压缩，找的时候顺带着把节点全部直接指向根
        public int findRoot(int x) {
            if (this.roots[x] == x) {
                return this.roots[x];
            }
            return roots[x] = findRoot(this.roots[x]);
        }

        //按秩合并，即矮的合入高的，这样高度不增加
        public void union(int x, int y) {
            int rootX = findRoot(x);
            int rootY = findRoot(y);
            if (rootX != rootY) {
                if (this.rank[rootX] > this.rank[rootY]) {
                    this.roots[rootY] = rootX;
                } else if (this.rank[rootX] < this.rank[rootY]) {
                    this.roots[rootX] = rootY;
                } else {
                    this.roots[rootY] = rootX;
                    this.rank[rootX]++;
                }
            }
        }

        public boolean isConnected(int x, int y) {
            return findRoot(x) == findRoot(y);
        }
    }

    //by kruskal
    public int minCostConnectPoints1(int[][] points) {
        int sum = 0;
        int cnt = 0;
        UnionFind unionFind = new UnionFind(points.length);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] a, int[] b) -> {
            return a[2] - b[2];
        });
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                priorityQueue.offer(new int[]{i, j, distance});
            }
        }
        List<int[]> list = new ArrayList<>();
        while (cnt < points.length - 1) {
            int[] cur = priorityQueue.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];
            if (!unionFind.isConnected(x, y)) {
                unionFind.union(x, y);
                list.add(cur);
                sum += cost;
                cnt++;
            }
        }
        for (int[] l : list) {
            System.out.println(l[0] + " " + l[1] + " " + l[2]);
        }
        return sum;
    }

    //by prim
    public int minCostConnectPoints2(int[][] points) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] a, int[] b) -> {
            return a[2] - b[2];
        });
        int nums = points.length;
        boolean[] visited = new boolean[nums];
        for (int i = 1; i < nums; i++) {
            int x1 = points[0][0];
            int y1 = points[0][1];
            int x2 = points[i][0];
            int y2 = points[i][1];
            int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
            priorityQueue.offer(new int[]{0, i, distance});
        }
        visited[0] = true;
        int cost = 0;
        int cnt = 0;
        List<int[]> edges = new ArrayList<>();
        while (cnt < nums - 1) {
            int[] edge = priorityQueue.poll();
            int point = edge[1];
            if (!visited[point]) {
                int x1 = points[point][0];
                int y1 = points[point][1];
                edges.add(edge);
                visited[point] = true;
                cost += edge[2];
                cnt++;
                for (int i = 0; i < nums; i++) {
                    if (!visited[i]) {
                        int x2 = points[i][0];
                        int y2 = points[i][1];
                        int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                        priorityQueue.offer(new int[]{point, i, distance});
                    }
                }
            }
        }
        return cost;
    }
}
