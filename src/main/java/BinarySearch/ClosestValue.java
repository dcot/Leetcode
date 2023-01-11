package BinarySearch;

public class ClosestValue {

    TreeNode ans;
    Double min = Double.MAX_VALUE / 2;

    public int closestValue(TreeNode root, double target) {
        search(root, target);
        return ans.val;
    }

    public void search(TreeNode root, double target) {
        if (root == null) return;
        Double res = Math.abs(root.val - target);
        if (res < min) {
            min = res;
            ans = root;
        }

        if (target < root.val) {
            search(root.left, target);
        } else {
            search(root.right, target);
        }
    }

}
