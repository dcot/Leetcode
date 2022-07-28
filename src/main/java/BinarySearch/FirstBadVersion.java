package BinarySearch;

public class FirstBadVersion {
    public boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        if (n < 1) return -1;
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
