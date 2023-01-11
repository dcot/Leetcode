package BinarySearch;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int l = 0;
        int r = nums.length - 1;
        int m1 = 0;
        //find left bound
        while (l + 1 < r) {
            m1 = l + (r - l) / 2;
            if (nums[m1] < target) {
                l = m1;
            } else {
                r = m1;
            }
        }
        //找左边界先判断l
        if (nums[l] == target) m1 = l;
        else if (nums[r] == target) m1 = r;
        else if (nums[l] != target && nums[r] != target) m1 = -1;
        l = 0;
        r = nums.length - 1;
        int m2 = 0;
        //find right bound
        while (l + 1 < r) {
            m2 = l + (r - l) / 2;
            if (nums[m2] <= target) {
                l = m2;
            } else {
                r = m2;
            }
        }
        //找右边界先判断r
        if (nums[r] == target) m2 = r;
        else if (nums[l] == target) m2 = l;
        else if (nums[l] != target && nums[r] != target) m2 = -1;
        return new int[]{m1, m2};
    }
}
