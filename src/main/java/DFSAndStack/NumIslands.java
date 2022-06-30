package DFSAndStack;

public class NumIslands {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int cnt = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return cnt;
    }

    public void dfs(char[][] grid, int row, int col, int rows, int cols) {
        if (isValid(row, col, rows, cols) && grid[row][col] == '1') {
            grid[row][col] = '0';
            for (int[] dir : dirs) {
                int x = dir[0] + row;
                int y = dir[1] + col;
                dfs(grid, x, y, rows, cols);
            }
        }
    }

    public boolean isValid(int row, int col, int rows, int cols) {
        if (row < rows && col < cols && row >= 0 && col >= 0) return true;
        else return false;
    }
}
