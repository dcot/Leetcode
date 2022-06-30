package interview;

public class ByteDance {
    public int huiwen(String s){
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (isHuiwen(s.substring(i,j))) {
                    max = j-i > max ? j-i : max;
                }
            }
        }
        return max;
    }
    public boolean isHuiwen(String s){
        int i = 0;
        int j = s.length()-1;
        while (i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int bin(int[] nums) {
        if (nums.length < 2) return -1;
        int index = -1;
        int r = nums.length-1;
        int l = 0;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if (mid == 0 && nums[0] > nums[1]) {
                index = mid;
                break;
            }
            else if (mid == nums.length-1 && nums[mid] > nums[mid-1]) {
                index = mid;
                break;
            }
            else if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                index = mid;
                break;
            }
            else if (nums[mid] < nums[mid-1]) {
                r = mid-1;
            }
            else if (nums[mid] < nums[mid+1]) {
                l = mid+1;
            }
        }
        return index;
    }
}
