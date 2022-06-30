package DFSAndStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    Deque<Integer> main;
    Deque<Integer> help;
    /** Initialize your data structure here. */
    public MyQueue() {
        main = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        main.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!help.isEmpty()) return help.pop();

        while (!main.isEmpty()) {
            help.push(main.pop());
        }
        return help.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!help.isEmpty()) return help.peek();

        while (!main.isEmpty()) {
            help.push(main.pop());
        }
        return help.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return main.isEmpty() && help.isEmpty();
    }
}
