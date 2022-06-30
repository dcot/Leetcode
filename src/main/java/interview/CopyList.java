package interview;

public class CopyList {
    class ListNode {
        int val;
        ListNode next;
        ListNode another;
    }

    public void copy(ListNode A, ListNode B) {
        ListNode Atemp = A;
        ListNode Btemp = B;
        for (; Atemp != null; Atemp = Atemp.next) {
            Btemp = new ListNode();
            Btemp.val = A.val;
        }
        Btemp = null;
        for (Atemp = A, Btemp = B; Atemp != null && Btemp != null; Atemp = Atemp.next, Btemp = Btemp.next) {
            Btemp.another = find(B, A.another.val);
        }
    }

    public ListNode find(ListNode B, int val) {
        ListNode Btemp = B;
        for (; Btemp != null; Btemp = Btemp.next) {
            if (Btemp.val == val) {
                break;
            }
        }
        return Btemp;
    }
}
