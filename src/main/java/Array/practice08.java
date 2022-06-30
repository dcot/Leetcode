package Array;

public class practice08 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        int[] index = {-1,-1};
        while(l<r){
            if(numbers[l]+numbers[r] == target){
                index[0] = l+1;
                index[1] = r+1;
                break;
            }
            else if(numbers[l]+numbers[r] < target){
                l++;
            }
            else{
                r--;
            }
        }
        return index;
    }
}
