package DFSAndStack;

import java.util.ArrayDeque;

public class DecodeString {
    public String decodeString(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (ch == ']') {
                StringBuilder content = new StringBuilder();
                char match = stack.pop();
                while (match != '[') {
                    content.append(match);
                    match = stack.pop();
                }
                char digit;
                int cnt = 0;
                int p = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    digit = stack.pop();
                    cnt += (digit - '0') * Math.pow(10,p++);
                }
                content = content.reverse();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < cnt; i++) {
                    temp.append(content);
                }
                for (char c : temp.toString().toCharArray()) {
                    stack.push(c);
                }
            }
            else {
                stack.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }
        return ans.reverse().toString();
    }
}
