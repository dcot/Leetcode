package BFSAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> main;
    Queue<Integer> help;
    /** Initialize your data structure here. */
    public MyStack() {
        main = new LinkedList<>();
        help = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        main.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!help.isEmpty()) return help.poll();

        while(!main.isEmpty()) {
            help.offer(main.poll());
        }
        return help.poll();
    }

    /** Get the top element. */
    public int top() {
        if (!help.isEmpty()) return help.peek();

        while(!main.isEmpty()) {
            help.offer(main.poll());
        }
        return help.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return help.isEmpty() && main.isEmpty();
    }
}
