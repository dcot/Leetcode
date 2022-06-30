package BinaryTree;

public class Symmetric {
    public boolean mirror(TreeNode root1,TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if ((root1 == null && root2 != null)
                || (root1 != null && root2 == null)
                || (root1.val != root2.val)) {
            return false;
        }
        return mirror(root1.left,root2.right) && mirror(root1.right,root2.left);
    }
}
