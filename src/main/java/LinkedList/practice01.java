package LinkedList;

import java.util.HashSet;

public class practice01 {
    public boolean hasCycle(ListNode head) {
        boolean res = false;
        if (head == null || head.next == null || head.next.next == null) {
            return res;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null) {
            if (slow == fast) {
                res = true;
                break;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast == null) break;
            fast = fast.next;
        }
        return res;
    }

    public boolean hasCycle2(ListNode head) {
        boolean res = false;
        HashSet<ListNode> hs = new HashSet<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (!hs.add(cur)) {
                res = true;
                break;
            }
        }
        return res;
    }
}
