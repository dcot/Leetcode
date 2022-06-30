package Gragh;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        path.add(0);
        visited[0] = true;
        dfs(graph,0, visited, path, paths);
        return paths;
    }
    //注意List<List<Integer>>中添加list，由于始终是指向一个list，paths.add(list)没有添加新list
    public void dfs(int[][] graph, int node, boolean[] visited, List<Integer> path, List<List<Integer>> paths){
        if (node == graph.length-1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int i : graph[node]) {
            if (!visited[i]) {
                path.add(i);
                dfs(graph, i, visited, path, paths);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }
}
