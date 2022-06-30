package Array;
//[0,1,0,3,12]
//[1,3,12,0,0]
public class practice01 {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int index = -1;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            index = searchZeroIndex(nums,length);
            if (index == -1) break;
            for (int j = index; j < length-1; j++) {
                temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
            length--;
        }
    }
    int searchZeroIndex(int[] nums,int length) {
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) index = i;
        }
        return index;
    }
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != 0){
                nums[j] = nums[k];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) nums[i] = 0;
    }
}
