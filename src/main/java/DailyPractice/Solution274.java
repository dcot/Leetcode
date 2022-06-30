package DailyPractice;

import java.util.Arrays;

public class Solution274 {
    /*
    3 0 6 1 5
    0 1 3 5 6
    1 1 3
     */
    public int hIndex(int[] citations) {
        int ans = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (ans >= citations[i]) {
                ans--;
                continue;
            }
            else {
                break;
            }
        }
        return ans+1;
    }
}
