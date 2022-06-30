package DailyPractice;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode first = head;
        if (first.next==null){
            return head;
        }
        ListNode second = first.next;
        while(second!=null){
            if(first.val == second.val){
                second = second.next;
                first.next = second;
            }
            else {
                first = first.next;
                second = second.next;
            }
        }
        return head;
    }
}
