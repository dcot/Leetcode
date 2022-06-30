package LinkedList;

import java.util.List;

public class practice10 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int sum = 0;
        int x = 0;
        int y = 0;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            x = 0;
            y = 0;
            if (l1!=null){
                x = l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                y = l2.val;
                l2 = l2.next;
            }
            sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10,null);
            cur = cur.next;
        }
        return dummy.next;
    }
}
