package LinkedList;

public class practice08 {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return  true;
        int count = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            count++;
            fast = fast.next;
        }
        fast = slow;
        ListNode vfast;
        if (count % 2 == 0) {
            for (int i = 0; i < count/2 - 1; i++) {
                fast = fast.next;
            }
            vfast = fast.next;
            slow = reverseList(head,vfast);
            while (vfast!=null){
                if (slow.val!=vfast.val) return false;
                slow = slow.next;
                vfast = vfast.next;
            }
        } else {
            for (int i = 0; i < count/2 - 1; i++) {
                fast = fast.next;
            }
            vfast = fast.next.next;
            slow = reverseList(head,fast.next);
            while (vfast!=null){
                if (slow.val!=vfast.val) return false;
                slow = slow.next;
                vfast = vfast.next;
            }
        }

        return true;
    }

    ListNode reverseList(ListNode head,ListNode end) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != end) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
            cur.next = prev;
        }
        return cur;
    }
}
