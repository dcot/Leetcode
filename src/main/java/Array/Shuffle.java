package Array;

public class Shuffle {
    public int[] shuffle(int[] arr, int i) {
        if (i == 0 || i == arr.length) return arr;
        int[] nums = new int[arr.length];
        int p1 = 0;
        int p2 = i;
        int length1 = i;
        int length2 = arr.length;
        int j = 0;
        while (p1 < length1 && p2 < length2) {
            nums[j++] = arr[p1++];
            nums[j++] = arr[p2++];
        }
        while (p1 < length1) nums[j++] = arr[p1++];
        while (p2 < length2) nums[j++] = arr[p2++];
        return nums;
    }
}
