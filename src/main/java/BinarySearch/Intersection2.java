package BinarySearch;

import java.util.*;

public class Intersection2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int[] ans = new int[nums1.length];
        for (int num : nums2) {
            int idx = binarySearch(nums1, num);
            if (idx != -1) {
                ans[i++] = num;
                nums1[idx] = -1;
            }
        }
        return Arrays.copyOfRange(ans, 0, i);
    }

    public int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r) {
            int m = (l+r)>>>1;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] >= target) {
                r = m;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
