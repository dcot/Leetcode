package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectRight {
    public Node connect1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            Node cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (pre != null) {
                    pre.next = cur;
                    pre = cur;
                } else {
                    pre = cur;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node();
            Node pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }
}
