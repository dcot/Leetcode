package BinarySearch;

public class GuessGame {
    public int guess(int num) {
        return 0;
    }
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        int num = 0;
        while(l <= r) {
            //int m = l + (r-l)/2;
            int m = (l+r)>>>1;
            if (guess(m) == 0) {
                num = m;
                break;
            }
            else if (guess(m) == 1){
                l = m + 1;
            }
            else if (guess(m) == -1) {
                r = m - 1;
            }
        }
        return num;
    }
}
