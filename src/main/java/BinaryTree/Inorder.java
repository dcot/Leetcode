package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        in(root, list);
        return list;
    }

    public void in(TreeNode root, List<Integer> list) {
        if (root == null) return;
        in(root.left, list);
        list.add(root.val);
        in(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
