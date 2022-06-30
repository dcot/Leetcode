package BFSAndQueue;

import java.util.*;

public class LevelOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            queue.add(root);
            int cnt = 1;
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                    list.add(temp.val);
                }
                if (cnt % 2 == 0) {
                    Collections.reverse(list);
                }
                result.add(list);
                cnt++;
            }
        }
        return result;
    }
}
