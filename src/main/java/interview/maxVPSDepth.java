package interview;

import java.util.ArrayDeque;

public class maxVPSDepth {

    public int maxDepth (String s) {
        // write code here
        int max = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        int i = 0;
        while (!stack.isEmpty() || i < len) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')'){
                max = Math.max(max, stack.size());
                stack.pop();
            }
            i++;
        }
        return max;
    }
}
