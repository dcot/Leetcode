package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class practice12 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        Node temp;
        while (cur != null) {
            temp = map.get(cur);
            temp.next = map.get(cur.next);
            temp.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
//    public Node copyRandomList(Node head) {
//        Node copyHead = new Node(10001);
//        Node copyCur = copyHead;
//        Node cur = head;
//        while (cur != null) {
//            copyCur.next = new Node(cur.val);
//            cur = cur.next;
//            copyCur = copyCur.next;
//        }
//        cur = head;
//        copyCur = copyHead.next;
//        while (cur != null) {
//            Node cursor = copyHead.next;
//            if (cur.random != null) {
//                //值会重复 所以不对
//                while (cursor.val != cur.random.val) cursor = cursor.next;
//                copyCur.random = cursor;
//            }
//            copyCur = copyCur.next;
//            cur = cur.next;
//        }
//        return copyHead.next;
//    }
}
