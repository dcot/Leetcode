package OJIO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringSort {
    /*
input:
5
c d a bb e
output:
a bb c d e
 */
    public void stringSort1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            String[] elements = new String[n];
            for (int i = 0; i < n; i++) {
                elements[i] = sc.next();
            }
            Arrays.sort(elements, (String s1, String s2) -> {
                return s1.compareTo(s2);
            });
            for (int i = 0; i < n; i++) {
                System.out.print(elements[i] + " ");
            }
        }
    }
    /*
input:
a c bb
f dddd
nowcoder
output:
a bb c
dddd f
nowcoder
*/
    public void stringSort2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] elements = line.split(" ");
            List<String> arr = Arrays.asList(elements);
            Collections.sort(arr,(String s1, String s2)->{
                return s1.compareTo(s2);
            });
            for (String value:arr) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
    /*
input:
a,c,bb
f,dddd
nowcoder
output:
a,bb,c
dddd,f
nowcoder
*/
    public void stringSort3() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] elements = line.split(",");
            Arrays.sort(elements,(String s1,String s2)->{
                return s1.compareTo(s2);
            });
            int i = 0;
            for (;i < elements.length - 1;i++) {
                System.out.print(elements[i]+",");
            }
            System.out.println(elements[i]);
        }
    }
}
