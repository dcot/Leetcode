package OJIO;

import java.util.Scanner;

public class AplusB {
    /*
    input:
    1 5
    10 20
    output:
    6
    30
     */
    public void AplusB1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            Long a = sc.nextLong();
            Long b = sc.nextLong();
            System.out.println(a + b);
        }
    }

    /*
input:
2
1 5
10 20
output:
6
30
 */
    public void AplusB2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }

    /*
input:
1 5
10 20
0 0
output:
6
30
*/
    public void AplusB3() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) break;
            System.out.println(a + b);
        }
    }

    /*
input:
4 1 2 3 4
5 1 2 3 4 5
0
output:
10
15
*/
    public void AplusB4() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            System.out.println(sum);
        }
    }

    /*
input:
2
4 1 2 3 4
5 1 2 3 4 5
output:
10
15
*/
    public void AplusB5() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    arr[j] = sc.nextInt();
                    sum += arr[j];
                }
                System.out.println(sum);
            }
        }
    }
    /*
input:
4 1 2 3 4
5 1 2 3 4 5
output:
10
15
*/
    public void AplusB6() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum+=sc.nextInt();
            }
            System.out.println(sum);
        }
    }
    /*
input:
1 2 3
4 5
0 0 0 0 0
output:
6
9
0
*/
    public void AplusB7() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] elements = line.split(" ");
            int[] nums = new int[elements.length];
            int sum = 0;
            for (int i = 0; i < elements.length; i++) {
                nums[i] = Integer.parseInt(elements[i]);
                sum += nums[i];
            }
            System.out.println(sum);
        }
    }
}
