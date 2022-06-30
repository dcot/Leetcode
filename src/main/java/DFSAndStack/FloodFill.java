package DFSAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];
        if (initColor == newColor) return image;
        int rows = image.length;
        int cols = image[0].length;
        dfs(image, sr, sc, rows, cols, initColor, newColor);
        return image;
    }

    public void dfs(int[][] image, int row, int col, int rows, int cols, int initColor, int newColor) {
        if (isValid(row, col, rows, cols) && image[row][col] == initColor) {
            image[row][col] = newColor;
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                dfs(image, r, c, rows, cols, initColor, newColor);
            }
        }
    }

    public int[][] bfs(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];
        if (initColor == newColor) return image;
        int rows = image.length;
        int cols = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int row = queue.peek()[0];
                int col = queue.poll()[1];
                for (int[] dir : dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (isValid(r, c, rows, cols) && image[r][c] == initColor) {
                        image[r][c] = newColor;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }
        return image;
    }

    public boolean isValid(int row, int col, int rows, int cols) {
        if (row < rows && col < cols && row >= 0 && col >= 0) return true;
        else return false;
    }
}
