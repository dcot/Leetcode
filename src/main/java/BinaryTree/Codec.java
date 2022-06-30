package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    public TreeNode helper(Queue<String> queue) {
        String temp = queue.poll();
        if (temp.equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(temp));
        treeNode.left = helper(queue);
        treeNode.right = helper(queue);
        return treeNode;
    }

}
