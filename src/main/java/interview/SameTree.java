package interview;

public class SameTree {
    public boolean isSame = true;

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    Boolean check(TreeNode a, TreeNode b) {
        traverse(a, b);
        return isSame;
    }

    void traverse(TreeNode a, TreeNode b) {
        TreeNode al = a.left;
        TreeNode ar = a.right;
        TreeNode bl = b.left;
        TreeNode br = b.right;
        if (al.value != bl.value && al.value != br.value) {
            isSame = false;
            return;
        }
        if (ar.value != bl.value && ar.value != br.value) {
            isSame = false;
            return;
        }
        traverse(a.left, b.left);
        traverse(a.right, b.right);
    }
}
