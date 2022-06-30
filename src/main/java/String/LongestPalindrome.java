package String;

public class LongestPalindrome {
    public String maxStr;
    public int maxLen = 0;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            getMaxPalindrome(s, i, i);
            getMaxPalindrome(s, i, i + 1);
        }
        return maxStr;
    }

    public void getMaxPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLen) {
            maxStr = s.substring(i + 1, j);
            maxLen = j - i - 1;
        }
    }
}
