package DailyPractice;

import java.util.HashMap;

public class Solution3 {
    //    public int lengthOfLongestSubstring(String s) {
//        int max = 0;
//        HashSet<Character> set;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.length() - i < max) break;
//            set = new HashSet<>();
//            int cnt = 0;
//            for (int j = i ; j < s.length(); j++) {
//                Character temp = s.charAt(j);
//                if (set.contains(temp)) {
//                    break;
//                }
//                else {
//                    set.add(temp);
//                    cnt++;
//                    if (cnt > max) max = cnt;
//                }
//            }
//        }
//        return max;
//    }
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!map.containsKey(temp)) {
                map.put(temp, i);
            } else {
                l = Math.max(map.get(temp) + 1, l);
                map.put(temp, i);
            }
            max = Math.max(i - l + 1, max);
        }
        return max;
    }
}
