package interview;

class BinSearch {
    // 请按你的实际需求修改参数
    /*
    0, 1, 3, 5, 7, 10
     */
    public int binarySearch(int[] nums, int target) {
        // 在这⾥书写你的代码
        int l = 0;
        int r = nums.length - 1;
        if (r == -1) return -1;
        int m;
        int index = -1;
        while (l <= r) {
            m = (l+r)>>1;
            if (nums[m] == target) {
                index = m;
            }
            else if (nums[m] < target) {
                l = m+1;
            }
            else {
                r = m-1;
            }
        }
        return index;
    }
}


