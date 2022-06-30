package LinkedList;

import java.util.Stack;

public class practice11 {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        Node curNext, childHead, childTail;
        while (cur!=null || !stack.isEmpty()) {
            if (cur.child != null) {
                stack.push(cur);
                cur = cur.child;
                continue;
            }
            if (cur.next == null && !stack.isEmpty()) {
                childTail = cur;
                cur = stack.pop();
                curNext = cur.next;
                childHead = cur.child;

                if (cur.next==null){
                    cur.next = childHead;
                    childHead.prev = cur;
                }
                else {
                    cur.next = childHead;
                    childHead.prev = cur;
                    curNext.prev = childTail;
                    childTail.next = curNext;
                }

                cur.child = null;
            }
            cur = cur.next;
        }
        return head;
    }
}
