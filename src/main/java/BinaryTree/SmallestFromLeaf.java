package BinaryTree;

public class SmallestFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        helper(root,ans);
        return ans.reverse().toString();
    }
    public void helper(TreeNode root,StringBuilder ans){
        ans.append((char)(root.val+'a'));
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (l == null && r == null) { return; }
        if (l == null && r != null) {
            helper(r,ans);
        }
        if (l != null && r == null) {
            helper(l,ans);
        }
        if (l != null && r != null) {
            if (l.val - r.val > 0) {
                helper(r,ans);
            }
            else {
                helper(l,ans);
            }
        }
    }
}
