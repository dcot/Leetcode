package BFSAndQueue;

import java.util.*;

public class WallAndGates {
//两个算法都超时
    //    public void wallsAndGates(int[][] rooms) {
//        for (int i = 0; i < rooms.length; i++) {
//            for (int j = 0; j < rooms[0].length; j++) {
//                if (rooms[i][j] == 0) dfs(rooms,i,j,0);
//            }
//        }
//    }
//
//    public void dfs(int[][] rooms, int x, int y, int val) {
//        if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y]==-1) {
//            return;
//        }
//        if (val < rooms[x][y]) rooms[x][y] = val;
//        dfs(rooms, x - 1, y, val + 1);
//        dfs(rooms, x + 1, y, val + 1);
//        dfs(rooms, x, y-1, val + 1);
//        dfs(rooms, x, y+1, val + 1);
//    }

    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        List<int[]> doors = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    doors.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < doors.size(); i++) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[rows][cols];
            int[] door = doors.get(i);
            queue.offer(door);
            visited[door[0]][door[1]] = true;
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                step++;
                for (int j = 0; j < size; j++) {
                    int[] cur = queue.poll();
                    for (int[] dir : dirs) {
                        int x = cur[0] + dir[0];
                        int y = cur[1] + dir[1];
                        if (isValid(x,y,rows,cols) && !visited[x][y] && rooms[x][y] != -1) {
                            queue.offer(new int[]{x,y});
                            if (rooms[x][y] > step) rooms[x][y] = step;
                            visited[x][y] = true;
                        }
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
