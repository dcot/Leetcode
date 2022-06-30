package BinaryTree;

import java.util.Arrays;

public class BuildTree {
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = preorder[0];
        int rootIndex = indexOf(inorder, treeNode.val);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftInorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftInorder.length, preorder.length);

        if (leftInorder.length == 0) {
            treeNode.left = null;
        } else {
            treeNode.left = buildTree1(leftPreorder, leftInorder);
        }

        if (rightInorder.length == 0) {
            treeNode.right = null;
        } else {
            treeNode.right = buildTree1(rightPreorder, rightInorder);
        }
        return treeNode;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = postorder[postorder.length - 1];
        int rootIndex = indexOf(inorder, treeNode.val);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftInorder.length, postorder.length - 1);

        if (leftInorder.length == 0) {
            treeNode.left = null;
        } else {
            treeNode.left = buildTree2(leftInorder, leftPostorder);
        }

        if (rightInorder.length == 0) {
            treeNode.right = null;
        } else {
            treeNode.right = buildTree2(rightInorder ,rightPostorder);
        }
        return treeNode;
    }

    public int indexOf(int[] nums, int target) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
