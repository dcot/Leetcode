package Gragh;

import java.util.Arrays;
import java.util.HashSet;

public class FindCircleNum {
    private int[] roots;
    private int[] rank;
    private int cnt;
    public void init(int size) {
        this.roots = new int[size];
        this.rank = new int[size];
        this.cnt = size;
        for (int i = 0; i < size; i++) {
            this.roots[i] = i;
            this.rank[i] = 1;
        }
    }

    public int findRoot(int x) {
        if (this.roots[x] == x) {
            return this.roots[x];
        }
        return this.roots[x] = findRoot(this.roots[x]);
    }

    public void union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if (rootX != rootY) {
            if (this.rank[rootX] > this.rank[rootY]) {
                this.roots[rootY] = rootX;
            }
            else if (this.rank[rootX] < this.rank[rootY]) {
                this.roots[rootX] = rootY;
            }
            else {
                this.roots[rootY] = rootX;
                this.rank[rootX]++;
            }
            this.cnt--;
        }
    }

    public boolean isConnected(int x, int y) {
        return findRoot(x) == findRoot(y);
    }

    public int findCircleNum(int[][] isConnected) {
        int rows = isConnected.length;
        int cols = isConnected[0].length;
        init(rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isConnected[i][j] == 1) {
                    this.union(i,j);
                }
            }
        }
        return this.cnt;
    }
}
