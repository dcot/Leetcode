package Array;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        int mark = 0;
        for (int i = nums.length-2; i >= 0 ; i--) {
            if (nums[i] < nums[i+1]) {
                mark = i;
            }
        }

    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
