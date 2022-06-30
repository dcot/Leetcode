package BFSAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        queue.offer(path);
        while (!queue.isEmpty()) {
            path = queue.poll();
            int cur = path.get(path.size() - 1);
            if (cur == graph.length - 1) {
                paths.add(path);
            }
            for (int i = 0; i < graph[cur].length; i++) {
                List<Integer> temp = new ArrayList<>(path);
                temp.add(graph[cur][i]);
                queue.add(temp);
            }
        }
        return paths;
    }
}
