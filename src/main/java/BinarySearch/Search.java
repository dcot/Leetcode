package BinarySearch;

public class Search {
    public int search1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int index = -1;
        while (l <= r) {
            int m = (l + r) >>> 1;
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

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length;
        int index = -1;
        //l必须小于r，如果l等于r就会越界
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                index = m;
                break;
            } else if (nums[m] < target) {
                //当target为一个大于数组中任何元素的数时，如果不取m+1则无法跳出循环
                l = m + 1;
            } else {
                //取值为区间最大索引+1，同r = nums.length
                r = m;
            }
        }
        return index;
    }
}
