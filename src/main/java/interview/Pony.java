package interview;

import static java.lang.Math.abs;

public class Pony {
    public int minTimeToType(String word) {
        int total = 0;
        int cost = 0;
        char cur = 'a';
        for (int i = 0; i < word.length(); i++) {
            char target = word.charAt(i);
            if (cur == target) {
                total+=1;
            }
            else {
                if (Math.abs(target - cur) > 13) {
                    cost = 13 - Math.abs(target - cur)%13;
                }
                else {
                    cost = Math.abs(target - cur);
                }
                total = total + cost + 1;
                cur = target;
            }
        }
        return total;
    }
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Math.abs(matrix[0][0]);
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += Math.abs(matrix[i][j]);
                if (Math.abs(matrix[i][j]) < min) min = Math.abs(matrix[i][j]);
                if (matrix[i][j] < 0) count++;
            }
        }
        if (count % 2 == 0) {
            return sum;
        }
        else {

        }
        return sum - min*2;
    }
    public int countPaths(int n, int[][] roads) {



        return 0;
    }
}
