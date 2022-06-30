package DFSAndStack;

import java.util.ArrayDeque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i] ) {
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
