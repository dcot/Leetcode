package Array;

public class practice11 {
//    for (int j = height.length-1; j > i ; j--) {
//        if(height[i]>height[j]) tall = height[j];
//        else tall = height[i];
//        area = (j-i)*tall;
//        if(area>max) max = area;
//    }
    public int maxArea(int[] height) {
        int max = 0;
        int tall = 0;
        int area = 0;
        int i = 0;
        int j = height.length-1;
        while(i<j){
            if(height[i]>height[j]){
                area = (j-i)*height[j];
                if (area > max) max = area;
                j--;
            }
            else{
                area = (j-i)*height[i];
                if (area > max) max = area;
                i++;
            }
        }
        return max;
    }
}
