package BinarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public int findPeakElement2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
//        if (nums.length == 1) return 0;
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
                return m;
            } else if (nums[m] > nums[m + 1]) {
                r = m;
            } else if (nums[m] < nums[m + 1]) {
                l = m;
            }
        }
//        if (l == 0 && nums[l] > nums[l+1]) return l;
//        if (r == nums.length-1 && nums[r] > nums[r-1]) return r;
//        return -1;
        return nums[l] > nums[r] ? l : r;
    }
}
