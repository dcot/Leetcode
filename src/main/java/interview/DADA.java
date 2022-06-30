package interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DADA {
    public void printMatrix() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int cnt = (1+n)*n/2;
            int[][] mat = new int[n][2*n];
            for (int i = 0; i < n; i++) {
                int j = 2*n-1;
                for(int k = 0; k <= i; k++) {
                    if (cnt < 10) {
                        mat[i][j--] = cnt;
                        mat[i][j--] = 0;
                    } else {
                        String temp = Integer.toString(cnt);
                        for (int l = temp.length() - 1; l >= 0; l--) {
                            mat[i][j--] = temp.charAt(l) - '0';
                        }
                    }
                    cnt--;
                }
                for (int k = j; k >= 0 ; k--) {
                    mat[i][k] = 0;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2*n; j++) {
                    System.out.print(mat[i][j]);
                }
                System.out.println();
            }
        }
    }
    public void reverseByN() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String N = in.nextLine();
            int n = Integer.parseInt(N);
            String[] nums = line.split(" ");
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(Integer.parseInt(nums[i]));
            }
            if (n > list.size()) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i)+" ");
                }
            }
            else {
                for (int i = 0; i < list.size()/n; i++) {
                    for (int j = (i+1)*n-1; j >= i*n; j--) {
                        System.out.print(list.get(j)+" ");
                    }
                    if (i+1 >= list.size()/n) {
                        for (int j = (i+1)*n; j < list.size(); j++) {
                            System.out.print(list.get(j)+" ");
                        }
                        break;
                    }
                }
            }
        }
    }
}
