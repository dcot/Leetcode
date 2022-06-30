package BFSAndQueue;

public class LatestDayToCross {
    public boolean res = false;
    public boolean[][] visited;

    public int latestDayToCross(int row, int col, int[][] cells) {
        int ans = 0;
        int rows = row + 1;
        int cols = col + 1;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i][0] = 1;
        }
        for (int[] cell : cells) {
            matrix[cell[0]][cell[1]] = 1;
        }
        for (int i = cells.length - 1; i >= 0; i--) {
            visited = new boolean[rows][cols];
            DFS(0, 1, matrix, rows, cols);
            if (this.res == true) {
                return i + 1;
            }
            matrix[cells[i][0]][cells[i][1]] = 0;
        }
        return ans;
    }

    public void BFS(int[][] matrix,int rows,int cols) {

    }

    public void DFS(int x, int y, int[][] matrix, int rows, int cols) {
        if (isValid(x,y,rows,cols)) {
            if (matrix[x][y] == 0 && this.res == false && !visited[x][y]) {
                visited[x][y] = true;
                if (x == rows - 1) {
                    this.res = true;
                    return;
                } else {
                    DFS(x, y + 1, matrix, rows, cols);
                    DFS(x + 1, y, matrix, rows, cols);
                    DFS(x - 1, y, matrix, rows, cols);
                    DFS(x, y - 1, matrix, rows, cols);
                }
            }
        }
    }

    public boolean isValid(int x, int y, int rows, int cols) {
        if (x >= 0 && x < rows && y >= 0 && y < cols) return true;
        else return false;
    }
}
