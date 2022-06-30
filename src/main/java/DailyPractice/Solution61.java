package DailyPractice;
//尾结点连接头节点，尾结点的上一节点的next为null，并记录为尾结点
//尾结点变成头结点，尾结点连接头结点并设置为head
//cur   tailPre   tail
// 1  2  3         4
//       tp  null  cur
//1 2 3 4   0
//4 1 2 3   1
//3 4 1 2   2
//2 3 4 1   3
//1 2 3 4   4 length%k==0
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        ListNode newHead = head.next;
        ListNode newTail = head;
        int length = 0;
        int mov = 0;
        while(tail!=null){
            length++;
            tail = tail.next;
        }
        if (length%k==0) return head;
        mov = length-k-1;
        for (int i = 0;i < mov;i++){
            newHead = newHead.next;
            newTail = newTail.next;
        }
        tail.next = head;
        newTail.next=null;
        head = newHead;
        return head;
    }
}
