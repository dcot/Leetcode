package BinarySearch;

public class SQRT {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 0;
        int r = x;
        int m = -1;
        while(l <= r) {
            m = l + (r-l)/2;
            if (x/m == m) {
                return m;
            }
            else if (x/m < m) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }        }
        return r;
    }
}
