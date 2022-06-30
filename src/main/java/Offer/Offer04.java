package Offer;

public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix[i].length; i++) {
            if (binarySearch(matrix[i],0,matrix[i].length-1,target))
                return true;
        }
        return false;
    }
    public static Boolean binarySearch(int[] arr, int l, int r, int target){
        int left = l;
        int right = r;
        while(left <= right){
            int mid = left + (right - left)/2;
            if (arr[mid] == target){
                return true;
            }
            else if (arr[mid] > target){
                right = mid - 1;
            }
            else if (arr[mid] < target){
                left = mid + 1;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        int i = row-1;
        int j = 0;
        while(i<row && j<col
        && i>=0 && j>=0){
            if (matrix[i][j] == target) {
                return true;
            }
            else if(matrix[i][j] < target) {
                j++;
            }
            else {
                i--;
            }
        }
        return false;
    }
}
