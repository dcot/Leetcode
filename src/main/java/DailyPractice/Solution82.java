package DailyPractice;

import java.util.HashMap;

//关键技巧，头部放置哑结点，随后返回头部的下一个
// * 如果二三指针相同，三指针往后走直到与二指针不同，一指针连接三指针
// * 如果一二指针相同，三指针判断是否相同，相同就往后走，直到第一个不同与二指针的值，然后一指针等于三指针，二三指针依次后移
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while(first!=null){
            if (hashMap.containsKey(first.val)){
                hashMap.put(first.val, hashMap.get(first.val)+1);
            }else{
                hashMap.put(first.val, 1);
            }
            first = first.next;
        }
        //hashMap.forEach((K,V)->System.out.println(K+":"+V));
        first = head;
        ListNode tempHead = new ListNode();
        ListNode tempCur ;
        ListNode tempPre = tempHead;
        while(first!=null){
            if(hashMap.get(first.val)==1){
                tempCur = new ListNode(first.val);
                tempPre.next = tempCur;
                tempPre = tempPre.next;
                tempCur = tempCur.next;
                tempCur = null;
            }
            first = first.next;
        }
        return tempHead.next;
    }

}
