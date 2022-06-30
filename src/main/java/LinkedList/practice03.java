package LinkedList;

public class practice03 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int count = 0;
        while (curA!=null&&curB!=null){
            curA = curA.next;
            curB = curB.next;
        }
        if (curA==null) {
            while(curB!=null) {
                curB = curB.next;
                count++;
            }
            for (int i = 0; i < count; i++) {
                headB = headB.next;
            }
        }
        else{
            while(curA!=null) {
                curA = curA.next;
                count++;
            }
            for (int i = 0; i < count; i++) {
                headA = headA.next;
            }
        }
        while (headA!=null&&headB!=null){
            if (headA==headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
