package DFSAndStack;

import java.util.ArrayDeque;

public class ReverseWords {
    public String reverseWords (String s, int i) {
        if (s.length() == 0) return s;
        String[] word = s.split(" ");
        if (i >= word.length || i <= 0) return s;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int j = 0; j < i; j++) {
            stack.push(word[j]);
        }
        for (int j = 0; j < i; j++) {
            sb.append(stack.pop());
            if (j != word.length - 1) {
                sb.append(" ");
            }
        }
        for (int j = i; j < word.length; j++) {
            stack.push(word[j]);
        }
        for (int j = i; j < word.length; j++) {
            sb.append(stack.pop());
            if (j != word.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
