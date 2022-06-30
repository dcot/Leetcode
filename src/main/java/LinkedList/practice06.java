package LinkedList;

public class practice06 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode prev = vhead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                prev.next = cur;
            }
            else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return vhead.next;
    }
}
