package LinkedList;

public class practice04 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vhead = new ListNode(-1);
        vhead.next = head;
        head = vhead;
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n ; i++) {
            second = second.next;
            if (second==null) return head;
        }

        while(second.next!=null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
}
