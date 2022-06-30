package DailyPractice;

public class Solution581 {
    //    public int findUnsortedSubarray(int[] nums) {
////        int start = 0;
////        int end = 1;
////        boolean isFirst = true;
////        for (int i = 0; i < nums.length - 1; i++) {
////            if (nums[i] > nums[i+1] && isFirst) {
////                start = i;
////                isFirst = false;
////                continue;
////            }
////            if (nums[i] > nums[i+1] && !isFirst) {
////                end = i + 1;
////            }
////        }
////        if (isFirst) {
////            return 0;
////        }else {
////            return end - start + 1;
////        }
//    }
    public int findUnsortedSubarray(int[] nums) {
        int start = -1, end = -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                end = i;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                start = i;
            }
        }
        if (start == end && start == -1) return 0;
        else return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(new Solution581().findUnsortedSubarray(nums));
    }
}
