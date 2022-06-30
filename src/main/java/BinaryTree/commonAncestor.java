package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class commonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode,TreeNode> hashMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            hashMap.put(root,null);
        }
        while (!hashMap.containsKey(p) || !hashMap.containsKey(q)) {
            root = queue.poll();
            if (root.left != null) {
                queue.offer(root.left);
                hashMap.put(root.left,root);
            }
            if (root.right != null) {
                queue.offer(root.right);
                hashMap.put(root.right,root);
            }
        }
        HashSet<TreeNode> path = new HashSet<>();
        TreeNode treeNode = p;
        while (treeNode != null) {
            path.add(treeNode);
            treeNode = hashMap.get(treeNode);
        }
        treeNode = q;
        while (!path.contains(treeNode)) {
            treeNode = hashMap.get(treeNode);
        }
        return treeNode;
    }
}
