package BFSAndQueue;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    List<List<Integer>> list = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        visited = new boolean[length];
        List<Integer> path = new ArrayList<>();
        int level = 0;
        dfs(path, nums, visited,length, level);
        return list;
    }

    public void dfs(List<Integer> path, int[] nums, boolean[] visited, int length, int level) {
        if (level == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                level++;
                dfs(path, nums, visited,length, level);
                visited[i] = false;
                path.remove(path.size()-1);
                level--;
            }
        }
    }
}
