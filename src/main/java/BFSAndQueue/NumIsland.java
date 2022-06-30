package BFSAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class NumIsland {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    BFS(grid, i, j, rows, cols);
                }
            }
        }
        return cnt;
    }

    public void BFS(char[][] grid, int x, int y, int rows, int cols) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        grid[x][y] = '0';
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if (isValid(r, c, rows, cols) && grid[r][c] == '1') {
                        queue.offer(new int[]{r,c});
                        grid[r][c] = '0';
                    }
                }
            }
        }
    }

    public boolean isValid(int x, int y, int rows, int cols) {
        if (x >= 0 && x < rows && y >= 0 && y < cols) return true;
        else return false;
    }
}
