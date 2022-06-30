package BinarySearch;

public class Search {
    public int search1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        int index = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                index = m;
                break;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return index;
    }
}
