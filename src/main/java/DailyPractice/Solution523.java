package DailyPractice;

public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        boolean res = false;
        int[][] mat = new int[nums.length][nums.length];



        return res;
    }
    public int cal(int[] nums, int low, int high){
        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
