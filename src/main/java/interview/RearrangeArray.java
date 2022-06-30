package interview;

import java.util.Arrays;

public class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 1; i < length - 1; i++) {
            float a = nums[i - 1];
            float b = nums[i + 1];
            if ((a + b) / 2 == nums[i]) {
                int mark = more(nums, length, i + 1);
                if (mark == -1) {
                    mark = less(nums, length, i - 1);
                    if (mark == -1) {
                        swap(nums, i, i + 1);
                        continue;
                    }
                    swap(nums, i - 1, mark);
                } else {
                    swap(nums, i + 1, mark);
                }
            }
        }
        return nums;
    }

    public int more(int[] nums, int length, int targetIndex) {
        int index = -1;
        for (int i = targetIndex + 1; i < nums.length; i++) {
            if (nums[i] > nums[targetIndex]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int less(int[] nums, int length, int targetIndex) {
        int index = -1;
        for (int i = targetIndex - 1; i >= 0; i--) {
            if (nums[i] < nums[targetIndex]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
