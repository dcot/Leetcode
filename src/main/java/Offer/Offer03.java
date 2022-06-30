package Offer;

public class Offer03 {
    public int findRepeatNumber1(int[] nums) {
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if (count[nums[i]] > 1) return nums[i];
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums){
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){
                if(nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                else{
                    temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }
        return 0;
    }
}
