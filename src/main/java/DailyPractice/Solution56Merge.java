package DailyPractice;



import java.util.*;

public class Solution56Merge {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (int[]a, int[]b)->{return a[0]-b[0];});

        int start = intervals[0][0];
        int end = intervals[0][1];
        boolean merged = false;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = intervals[i][1] > end ? intervals[i][1] : end;
                start = intervals[i][0] < start ? intervals[i][0] : start;
            } else {
                list.add(new int[]{start,end});
                merged = true;
            }

            if (merged) {
                start = intervals[i][0];
                end = intervals[i][1];
                merged = false;
            }
        }


        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][2]);
    }
}
