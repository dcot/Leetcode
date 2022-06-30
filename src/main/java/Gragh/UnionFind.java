package Gragh;

import java.util.Arrays;
import java.util.HashMap;

public class UnionFind {
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
            }
            else if (this.rank[rootX] < this.rank[rootY]) {
                this.roots[rootX] = rootY;
            }
            else {
                this.roots[rootY] = rootX;
                this.rank[rootX]++;
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return findRoot(x) == findRoot(y);
    }
}
