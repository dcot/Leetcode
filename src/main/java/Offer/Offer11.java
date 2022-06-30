package Offer;

public class Offer11 {
    // 1 2 3 4 5 6 7
    // 5 6 7 1 2 3 4
    // 4 5 6 7 1 2 3
    // 取区间中值
    // 如果区间相遇，就是最小值
    // 如果中值大于右端点又大于左端点 最小值在右边
    // 如果中值小于右端点又小于左端点 最小值在左边
    // 还需要考虑num[mid] == num[r]的情况，只比较num[mid]和num[r]，因为每次二分都是为了确定num[mid]在哪里
    // 而比较num[l]确定不了num[mid]的位置
    public int minArray(int[] numbers) {
        int res = 0;
        int l = 0;
        int r = numbers.length - 1;
        int mid = 0;
        while(l<=r){
            mid = (l+r)/2;
            res = numbers[mid];
            if(numbers[mid]>numbers[r]){
                l = mid + 1;
            }
            else if(numbers[mid]<numbers[r]){
                r = mid;
            }
            else{
                r--;
            }
        }
        return res;
    }
}
