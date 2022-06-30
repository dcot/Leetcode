package DailyPractice;

import java.util.HashSet;

public class Solution1763 {
    public String longestNiceSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return "";
        int maxLength = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subStr = s.substring(i,j+1);
                if(isNice(subStr) && (j-i+1) > maxLength) {
                    maxLength = j-i+1;
                    res = new String(subStr);
                }
            }
        }
        return res;
    }
    boolean isNice(String s) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set1.add(s.charAt(i));
            set2.add(Character.toUpperCase(s.charAt(i)));
        }
        if (set1.size() == 2*set2.size()) return true;
        else return false;
    }
}
