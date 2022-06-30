package BinaryTree;

import java.util.*;

public class Postorder {
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        post(root, list);
        return list;
    }

    public void post(TreeNode root, List<Integer> list) {
        if (root == null) return;
        post(root.left, list);
        post(root.right, list);
        list.add(root.val);
    }

    //left right root ---> root right left
    //root left right
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        Collections.reverse(list);
        return list;
    }
}
