package BinarySearch;

public class RotateSortArray {
    /*
    [4,5,6,7,8,0,1,2],边界条件还是没搞太明白
     */
    public int search(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length-1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                index = m;
                break;
            }
            else if (nums[m] > nums[r]) {
                if (nums[m] > target && target >= nums[l]) {
                    r = m-1;
                }
                else {
                    l = m+1;
                }
            }
            else  {
                if (nums[m] < target && target <= nums[r]) {
                    l = m+1;
                }
                else {
                    r = m-1;
                }
            }
        }
        return index;
    }
}
