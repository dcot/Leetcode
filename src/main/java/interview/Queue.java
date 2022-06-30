package interview;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Queue {
    public int[] data = new int[10000];
    public int head;
    public int tail;

    public Queue() {
        head = 0;
        tail = 0;
    }

    // 3 4 5 7 9
    //   t h
    // t-h + length  % length
    public int push(int num) {
        if ((tail + 1 + data.length) % data.length == head) {
            return -1;
        }
        tail = (tail + 1 + data.length) % data.length;
        data[tail] = num;
        return 1;
    }

    //每次获取get tail的下标，cas比较下标，如果下标不变代表成功pop，否则失败，重新get下标再比较
    public int pop() {
        if (head == tail) return -1;
        int num = data[head];
        head = (head + 1 + data.length) % data.length;
        return num;
    }
}
