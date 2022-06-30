package DailyPractice;

import java.util.*;

public class Sol1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[mat.length];
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int num = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                if (mat[i][j] == 1) {
                    num++;
                }
            }
            map.put(i,num);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }
}
