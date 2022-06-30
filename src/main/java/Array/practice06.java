package Array;

import java.util.PriorityQueue;

public class practice06 {
    public int findKthLargest(int[] nums, int k) {
        int res = -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {return o2-o1;});
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            res = heap.poll();
        }
        return res;
    }


}
