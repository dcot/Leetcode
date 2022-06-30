package DFSAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int level = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int row = queue.peek()[0];
                int col = queue.poll()[1];
                for (int[] dir : dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (isValid(r, c, rows, cols) && !visited[r][c]) {
                        if (mat[r][c] == 1) {
                            mat[r][c] = level;
                            queue.offer(new int[]{r, c});
                            visited[r][c] = true;
                        }
                    }
                }
            }
        }
        return mat;
    }

    public boolean isValid(int row, int col, int rows, int cols) {
        if (row < rows && col < cols && row >= 0 && col >= 0) return true;
        else return false;
    }
}
