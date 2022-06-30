package Array;
//双指针思想就是，一个指针负责指向最后要完成的、返回的数组，一个指针负责比较、检查的操作
public class practice03 {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]){
                nums[j++] = nums[i+1];
            }
        }
        return j;
    }
}
