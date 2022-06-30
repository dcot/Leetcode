package DailyPractice;

import java.util.*;

public class Solution451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == null) {
                hashMap.put(s.charAt(i), 1);
            } else {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, (Map.Entry<Character, Integer> m1, Map.Entry<Character, Integer> m2) -> {
            return m2.getValue() - m1.getValue();
        });
        String ans = new String();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getValue(); j++) {
                ans += list.get(i).getKey();
            }
        }
        return ans;
    }
}
