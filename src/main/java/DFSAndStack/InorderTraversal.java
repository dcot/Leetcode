package DFSAndStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null) {
            HashSet<TreeNode> visited = new HashSet<>();
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            visited.add(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null && !visited.contains(cur.left)) {
                    stack.push(cur.left);
                    visited.add(cur.left);
                    continue;
                } else {
                    cur = stack.pop();
                    list.add(cur.val);
                }

                if (cur.right != null && !visited.contains(cur.right)) {
                    stack.push(cur.right);
                    visited.add(cur.right);
                }
            }
        }
        return list;
    }
}
