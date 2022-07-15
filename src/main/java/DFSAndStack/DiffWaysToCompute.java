package DFSAndStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> l = diffWaysToCompute(expression.substring(0,i));
                List<Integer> r = diffWaysToCompute(expression.substring(i+1,expression.length()));
                for (int a : l) {
                    for (int b : r) {
                        if (ch == '+') {
                            list.add(a+b);
                        } else if (ch == '-') {
                            list.add(a-b);
                        } else if (ch == '*') {
                            list.add(a*b);
                        }
                    }
                }
            }
        }
        if (list.isEmpty()) {
            list.add(Integer.parseInt(expression));
        }
        return list;
    }
}
