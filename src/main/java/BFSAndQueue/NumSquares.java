package BFSAndQueue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumSquares {
    public int numSquares(int n) {
        int cnt = 0;
        if (n == 0) return cnt;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j <= n; j++) {
                    int temp = cur + j * j;
                    if (temp < n) {
                        if (!visited.contains(temp)) {
                            visited.add(temp);
                            queue.offer(temp);
                        }
                    } else if (temp == n) {
                        return cnt;
                    } else {
                        break;
                    }
                }
            }
        }
        return cnt;
    }
}
