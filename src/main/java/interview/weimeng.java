package interview;

import LinkedList.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class weimeng {
    ArrayList<String> list = new ArrayList<>();
    boolean[] visited;
    int cnt = 0;

    public ArrayList<String> getPermutation(String A) {
        // write code here
        char[] chs = A.toCharArray();
        int length = chs.length;
        visited = new boolean[length];
        StringBuilder sb = new StringBuilder();
        int level = 0;
        dfs(sb, chs, visited, length, level);
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }

    public void dfs(StringBuilder sb, char[] chs, boolean[] visited, int length, int level) {
        if (level == length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                sb.append(chs[i]);
                visited[i] = true;
                dfs(sb, chs, visited, length, ++level);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
                level--;
            }
        }
    }

    public void reorderList(ListNode head) {
        ListNode p = head;
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        int length = 1;
        while (p != null) {
            p = p.next;
            length++;
        }
        if (length <= 2) return;
        ListNode p1 = head;
        ListNode p2;
        p = head;
        if (length % 2 == 0) {
            for (int i = 0; i < length / 2 - 1; i++) {
                p = p.next;
            }
        } else {
            for (int i = 0; i < length / 2 ; i++) {
                p = p.next;
            }
        }
        p2 = p.next;
        p.next = null;
        p = p2;
        p2 = p1.next;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        while(!stack.isEmpty()) {
            stack.peek().next = p2;
            p1.next = stack.peek();
            p1 = p2;
            p2 = p2.next;
            stack.pop();
        }
    }
}
