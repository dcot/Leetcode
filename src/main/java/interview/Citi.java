package interview;

public class Citi {
    public double getBookValue(double faceValue, double couponRate, double discountRate, int n) {
        // write code here
        double bookValue = 0;
        for (int i = 1; i <= n; i++) {
            double cash;
            if (i == n) {
                cash = faceValue * (1 + couponRate * 0.01);
            } else {
                cash = faceValue * couponRate * 0.01;
            }
            bookValue += cash / Math.pow((1 + 0.01 * discountRate), i);
        }
        return bookValue;
    }

    public int maxProfit(int[] prices) {
        // write code here
        int profit = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int minIndex = -1;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
                maxIndex = i;
            }
            if (prices[i] < min) {
                min = prices[i];
                minIndex = i;
            }
        }
        if (maxIndex > minIndex) {
            return max - min;
        } else {
            max = min;
            for (int i = minIndex; i < prices.length; i++) {
                if (prices[i] > max) {
                    max = prices[i];
                }
            }
            profit = max - min;
            max = prices[maxIndex];
            min = max;
            for (int i = maxIndex; i >= 0; i--) {
                if (prices[i] < min) {
                    min = prices[i];
                }
            }
            profit = (max - min) > profit ? (max - min) : profit;
        }
        return profit;
    }

    public String check(String word) {
        char[] chs = word.toCharArray();
        int length = word.length();
        if (length < 2) return "NO";
        for (int i = 0; i < length; ) {
            if (length - i == 1) return "NO";
            if ((chs[i] == 'c' && chs[i + 1] == 'i')
                    || (chs[i] == 't' && chs[i + 1] == 'i')) {
                i += 2;
            } else if (length - i >= 4) {
                if (chs[i] == 'b' && chs[i + 1] == 'a'
                        && chs[i + 2] == 'n' && chs[i + 3] == 'k') {
                    i += 4;
                }
                else {
                    return "NO";
                }
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}
