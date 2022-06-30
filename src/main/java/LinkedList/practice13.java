package LinkedList;

public class practice13 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode vhead = head;
        ListNode vtail = null;
        int length = 0;
        while (vhead != null) {
            length++;
            vhead = vhead.next;
        }
        k = k % length;
        if (k == 0) return head;
        vhead = head;
        for (int i = 0; i < length - k; i++) {
            vtail = vhead;
            vhead = vhead.next;
        }
        vtail.next = null;
        ListNode temp = vhead;
        while(temp.next!=null) temp = temp.next;
        temp.next = head;
        return vhead;
    }
}
