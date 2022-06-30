package DFSAndStack;

import java.util.ArrayDeque;


public class IsValid {
    //注意isempty判断要放前面
    public boolean isValid(String s) {
        ArrayDeque<Character> s1 = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') s1.push(')');
            else if (s.charAt(i) == '[') s1.push(']');
            else if (s.charAt(i) == '{') s1.push('}');
            else if (s.charAt(i) == ')') {
                if (s1.isEmpty() || s1.pop() != ')') return false;
            }
            else if (s.charAt(i) == ']') {
                if (s1.isEmpty() || s1.pop() != ']') return false;
            }
            else if (s.charAt(i) == '}') {
                if (s1.isEmpty() || s1.pop() != '}') return false;
            }
        }
        return s1.isEmpty();
    }
}
