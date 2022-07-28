package BinarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length-1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else{
                l = m+1;
            }
        }
        return l;
    }
}
