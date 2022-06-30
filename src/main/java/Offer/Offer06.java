//package offer;
//
//import java.util.Stack;
//
//public class Offer06 {
//
//    public int[] reversePrint(ListNode head) {
//        Stack<Integer> stack = new Stack<>();
//        int count = 0;
//        while (head!=null){
//            stack.push(head.val);
//            count++;;
//            head = head.next;
//        }
//        int[] arr = new int[count];
//        for (int i = 0; i < count; i++) {
//            arr[i] = stack.pop();
//        }
//        return arr;
//    }
//}
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}