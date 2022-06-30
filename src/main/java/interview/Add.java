package interview;

public class Add {
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //1-2-3  321  8-7-5  578+43=621
    //1-1    11   3-4
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        ListNode t1 = l1;
        ListNode t2 = l2;
        boolean add = false;
        if (len1 > len2) {
            while(t2 != null) {
                int temp = t1.val + t2.val;
                if (temp > 9) {
                    temp %= 10;
                    if (add) {
                        t1.val = temp + 1;
                    }
                    else {
                        t1.val = temp;
                    }
                    add = true;
                }
                else {
                    if (add) {
                        t1.val = temp + 1;
                    }
                    else {
                        t1.val = temp;
                    }
                    add = false;
                }
                t1 = t1.next;
                t2 = t2.next;
            }
            if (add) t1.val+=1;
            return l1;
        }
        else {
            while(t1 != null) {
                int temp = t1.val + t2.val;
                if (temp > 9) {
                    temp %= 10;
                    if (add) {
                        t1.val = temp + 1;
                    }
                    else {
                        t1.val = temp;
                    }
                    add = true;
                }
                else {
                    if (add) {
                        t1.val = temp + 1;
                    }
                    else {
                        t1.val = temp;
                    }
                    add = false;
                }
                t1 = t1.next;
                t2 = t2.next;
            }
            if (add) t2.val+=1;
            return l2;
        }
    }

    public int getLength(ListNode l) {
        int len = 0;
        for (ListNode temp = l; temp != null; temp = temp.next) {
            len++;
        }
        return len;
    }
}
