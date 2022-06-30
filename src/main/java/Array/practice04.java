package Array;

public class practice04 {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        int pre = -10001;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pre == nums[i]){
                count++;
                if (count <= 2){
                    nums[j++] = pre;
                }
            }
            else{
                pre = nums[i];
                nums[j++] = pre;
                count = 1;
            }
        }
        return j;
    }
}
