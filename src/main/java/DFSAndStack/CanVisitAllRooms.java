package DFSAndStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int length = rooms.size();
        boolean[] visited = new boolean[length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 0; j < rooms.get(cur).size(); j++) {
                    int key = rooms.get(cur).get(j);
                    if (!visited[key]) {
                        visited[key] = true;
                        queue.offer(key);
                    }
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) return visited[i];
        }
        return true;
    }

    public void dfs(boolean[] visited, int num, List<List<Integer>> rooms) {
        if (!visited[num]) {
            visited[num] = true;
            for (int i = 0; i < rooms.get(num).size(); i++) {
                dfs(visited, rooms.get(num).get(i), rooms);
            }
        }
    }
}
