package BFSAndQueue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        String init = "0000";
        StringBuilder sb = new StringBuilder(init);
        int cnt = 0;
        for (int i = 0; i < deadends.length; i++) {
            visited.add(deadends[i]);
        }
        if (!visited.contains(init)) {
            queue.offer(init);
            visited.add(init);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                String origin = queue.poll().toString();
                StringBuilder temp = new StringBuilder(origin);
                for (int j = 0; j < 4; j++) {
                    int digit = Integer.parseInt(temp.toString().substring(j, j + 1)) + 1;
                    digit %= 10;
                    temp.replace(j, j + 1, Integer.toString(digit));
                    String node = temp.toString();
                    if (node.equals(target)) return cnt;
                    if (!visited.contains(node)) {
                        queue.offer(node);
                        visited.add(node);
                    }
                    temp.replace(0, 4, origin);
                }
                for (int j = 0; j < 4; j++) {
                    int digit = Integer.parseInt(temp.toString().substring(j, j + 1)) - 1;
                    if (digit == -1) digit = 9;
                    temp.replace(j, j + 1, Integer.toString(digit));
                    String node = temp.toString();
                    if (node.equals(target)) return cnt;
                    if (!visited.contains(node)) {
                        queue.offer(node);
                        visited.add(node);
                    }
                    temp.replace(0, 4, origin);
                }
            }
        }
        return -1;
    }
}
