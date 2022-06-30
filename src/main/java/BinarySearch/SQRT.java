package BinarySearch;

public class SQRT {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 0;
        int r = x;
        int m = -1;
        while(l <= r) {
            m = (l+r)/2;
            int num = m*m;
            if (num == x) {
                return m;
            }
            else if (num < x) {
                l = m + 1;

            }
            else {
                r = m - 1;
            }
        }
        return r;
    }
}
