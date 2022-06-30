package BinaryTree;

public class MaxDepth {
    private int ans;

    public void maxDepthTopDown(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) ans = Math.max(depth, ans);
        ;
        maxDepthTopDown(root.left, depth + 1);
        maxDepthTopDown(root.right, depth + 1);
    }

    public int maxDepthDownTop(TreeNode root) {
        if (root == null) return 0;
        int leftAns = maxDepthDownTop(root.left);
        int rightAns = maxDepthDownTop(root.right);
        return Math.max(leftAns, rightAns) + 1;
    }
}
