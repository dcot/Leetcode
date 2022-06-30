package interview;

import BinaryTree.TreeNode;

public class xingzheng {
    public TreeNode root;

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return t1;
        }
        else if (t1 == null && t2 != null) {
            return t2;
        }
        else if (t2 == null && t1 != null) {
            return t2;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

    public void merge(TreeNode t1, TreeNode t2, TreeNode root) {
        if (t1 == null && t2 == null) {
            return;
        } else if (t1 != null && t2 != null) {
            root = new TreeNode();
            root.val = t1.val + t2.val;
            merge(t1.left, t2.left, root.left);
            merge(t1.right, t2.right, root.right);
        } else if (t1 != null && t2 == null) {
            root = new TreeNode();
            root.val = t1.val;
            return;
        } else if (t1 == null && t2 != null) {
            root = new TreeNode();
            root.val = t2.val;
            return;
        }

    }
}
