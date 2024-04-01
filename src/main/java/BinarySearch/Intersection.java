package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();
        for (int num : nums2) {
            int idx = binarySearch(nums1, num);
            if (idx != -1) set.add(num);
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for (int num : set) {
            ans[i++] = num;
        }
        return ans;
    }

    public int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r) {
            int m = (l+r)>>>1;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
