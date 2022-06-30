package Array;

public class practice02 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        int j = length-1;
        boolean flag = false;
        while(i<=j){
            for (int k = i; k <= j; k++) {
                if (nums[k] == val) {
                    i = k;
                    flag = true;
                    break;
                }
            }
            for (int k = j; k >= i ; k--) {
                if (nums[k]!=val){
                    j = k;
                    break;
                }
            }
            if (flag){
                nums[i] = nums[j];
                j--;
                i++;
                flag = false;
            }
            else {
                break;
            }
        }
        return j+1;
    }
    public int removeElement2(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
