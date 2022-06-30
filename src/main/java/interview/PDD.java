package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PDD {
    public void bookStore(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            int length = 0;
            for (int i = 0; i < n; i++) {
                int temp = in.nextInt();
                length += temp;
                arrayList.add(temp);
            }
            int[] arr = new int[length];
            int p = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                int times = arrayList.get(i);
                for (int j = 0; j < times; j++) {
                    arr[p++] = i+1;
                }
            }
            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                int temp = in.nextInt();
                System.out.println(arr[temp-1]);
            }
        }
    }
    public void moveChess() {
        HashMap<Integer, int[]> move = new HashMap<>();
        move.put(1,new int[]{-1,0});
        move.put(2,new int[]{0,-1});
        move.put(3,new int[]{1,0});
        move.put(4,new int[]{0,1});
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int m = in.nextInt();
                int x = in.nextInt();
                int y = in.nextInt();
                int[][] matrix = new int[x][y];
                int[] ops = new int[n];
                for (int j = 0; j < n; j++) {
                    ops[j] = in.nextInt();
                }
                for (int j = 0; j < m; j++) {
                    int r = in.nextInt();
                    int c = in.nextInt();
                    r--;
                    c--;
                    for (int k = 0; k < n; k++) {
                        int[] dir = move.get(ops[k]);
                        int row = r + dir[0];
                        int col = c + dir[1];
                        if(isValid(row, col, x, y)) {
                            r = row;
                            c = col;
                        }
                    }
                    System.out.println((r+1) + " " + (c+1));
                }
            }
        }
    }
    public static boolean isValid(int r, int c, int rows, int cols) {
        if (r >= 0 && r < rows && c >= 0 && c < cols) return true;
        else return false;
    }
}
