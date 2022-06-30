package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mihoyo {
    public int[][] SubSets (int[] a) {
        List<int[]> list = new ArrayList<>();
        int n = a.length;
        int window = 0;
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[1+window];
            int index = 0;
            tmp[index++] = a[i];
            for (int j = i+1; j+window < n; j++) {
                for (int k = j; k < j+window; k++) {
                    tmp[index++] = a[k];
                }
                list.add(tmp);
            }
            window++;
        }
        list.add(new int[]{});
        int[][] res = new int[list.size()][n];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public int PathsCnt (int m, int n) {
        int[][] mat = new int[m][n];
        mat[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i-1 >= 0) {
                    mat[i][j] += mat[i-1][j];
                }
                if (j-1 >= 0) {
                    mat[i][j] += mat[i][j-1];
                }
            }
        }
        return mat[m-1][n-1];
    }
}
