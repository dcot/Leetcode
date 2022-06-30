package BinaryTree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root != null) {
            if (root.left == null && root.right == null && targetSum - root.val == 0) return true;
            if (root.left == null && root.right == null && targetSum - root.val != 0) return false;
            return hasPathSum(root.left, targetSum - root.val)
                    || hasPathSum(root.right, targetSum - root.val);
        } else {
            return false;
        }
    }
}
