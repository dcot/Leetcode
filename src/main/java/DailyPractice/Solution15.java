package DailyPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    //-4,-1,-1,0,1,2
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int start = i+1;
            int end = nums.length-1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while(start < end && nums[start] == nums[++start]) ;
                    while(start < end && nums[end] == nums[--end]) ;
                }
                else if (sum < 0) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }
        return list;
    }
}
