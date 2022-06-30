package Array;

public class practice05 {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int i = 0;
        int temp;
        while(i<=r){
            //i无论如何都自增是因为[0...l-1]一定是0且i从0开始
            //如果有0，一开始就i++ l++ 如果有2直接就被挪到后面去了
            if (nums[i]==0){
                swap(nums,i,l);
                l++;
                i++;
            }
            //i不自增是因为从末尾换回来的可能是0或2
            else if(nums[i]==2){
                swap(nums,i,r);
                r--;
            }
            else {
                i++;
            }
        }
    }
    void swap(int[] nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
