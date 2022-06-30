package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Decompose {
    public void decompose() {
        int[] factor = {2,3,5,7,11,13,17,19,23,29,31,37,41,43};
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int temp = num;
            while(temp != 1) {
                for (int i = 0; i < factor.length; i++) {
                    if (temp % factor[i] == 0) {
                        temp /= factor[i];
                        list.add(factor[i]);
                    }
                }
            }
            Collections.sort(list);
            System.out.print(num + "=");
            for (int i = 0; i < list.size(); i++) {
                if (i == (list.size() -1)) {
                    System.out.println(list.get(i));
                }
                else {
                    System.out.print(list.get(i) + "*");
                }
            }
        }
    }
}
