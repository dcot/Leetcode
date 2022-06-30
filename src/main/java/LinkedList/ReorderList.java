package LinkedList;

import java.util.ArrayDeque;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode p = head;
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        int length = 1;
        while (p != null) {
            p = p.next;
            length++;
        }
        if (length <= 2) return;
        ListNode p1 = head;
        ListNode p2;
        p = head;
        if (length % 2 == 0) {
            for (int i = 0; i < length / 2 - 1; i++) {
                p = p.next;
            }
        } else {
            for (int i = 0; i < length / 2 ; i++) {
                p = p.next;
            }
        }
        p2 = p.next;
        p.next = null;
        p = p2;
        p2 = p1.next;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        while(!stack.isEmpty()) {
            stack.peek().next = p2;
            p1.next = stack.peek();
            p1 = p2;
            p2 = p2.next;
            stack.pop();
        }
    }
}
