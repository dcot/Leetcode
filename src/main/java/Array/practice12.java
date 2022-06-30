package Array;

public class practice12 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = 100001;
        int i = 0;
        int j = 0;
        int sum = 0;
        while(i<=j&&j<nums.length){
            if(i!=j) {
                for (int k = i; k <= j; k++) {
                    sum+=nums[k];
                }
            }
            else sum = nums[i];
            if(sum>=target){
                len = (j-i+1) < len ? (j-i+1) : len;
                i++;
            }
            else{
                j++;
            }
            sum = 0;
        }
        if (100001==len) len = 0;
        return len;
    }
}
