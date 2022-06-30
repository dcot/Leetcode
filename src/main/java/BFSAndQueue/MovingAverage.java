package BFSAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int winSize;
    double sum;
    Queue<Integer> queue;

    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.winSize = size;
        this.sum = 0;
    }

    public double next(int val) {
        double ans;
        if (queue.size() == this.winSize) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        ans = sum/queue.size();
        return ans;
    }
}
