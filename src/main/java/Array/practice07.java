package Array;

public class practice07 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = m+n-1;
        while (p1>=0&&p2>=0){
//            nums1[cur--] = nums1[p1]>nums2[p2] ? nums1[p1--] : nums2[p2--];
            if(nums1[p1]>=nums2[p2]){
                nums1[cur--] = nums1[p1--];
            }
            else {
                nums1[cur--] = nums2[p2--];
            }
        }
        while(p2>=0){
            nums1[cur--] = nums2[p2--];
        }
    }
}
