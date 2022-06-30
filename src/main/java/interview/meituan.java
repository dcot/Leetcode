package interview;

import java.util.Scanner;

public class meituan {
//    public static int max = 0;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        boolean[] visited = new boolean[m+1];
//        int[][] orders = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            orders[i][0] = in.nextInt();
//            orders[i][1] = in.nextInt();
//        }
//        dfs(visited, orders, 0, 0);
//        System.out.println(max);
//    }
//    public static void dfs(boolean[] visited, int[][] orders, int cnt, int index) {
//        if (cnt > max) {
//            max = cnt;
//        }
//        for (int i = index; i < orders.length; i++) {
//            int order1 = orders[i][0];
//            int order2 = orders[i][1];
//            if (!visited[order1] && !visited[order2]) {
//                visited[order1] = true;
//                visited[order2] = true;
//                dfs(visited, orders, cnt+1, index+1);
//                visited[order1] = false;
//                visited[order2] = false;
//            }
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        boolean[] nums = new boolean[n];
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            if (in.nextInt() > 0) nums[i] = true;
//            else nums[i] = false;
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                if (isAbove(i,j,nums)) cnt++;
//            }
//        }
//        System.out.println(cnt);
//    }
//    public static boolean isAbove(int start, int end, boolean[] nums) {
//        short sum = 1;
//        for (int i = start; i <= end; i++) {
//            if (nums[i] == false) sum*=-1;
//        }
//        if (sum > 0) return true;
//        else return false;
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            int num = in.nextInt();
//            if (num % 11 == 0 || isDoubleOne(num)) {
//                System.out.println("yes");
//            }
//            else {
//                System.out.println("no");
//            }
//        }
//    }
//    public static boolean isDoubleOne(int num) {
//        boolean res = false;
//        int cnt = 0;
//        String s = String.valueOf(num);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '1') {
//                cnt++;
//            }
//            if (cnt == 2) {
//                res = true;
//                break;
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[] rooms = new boolean[n+1];
        rooms[0] = true;
        int[] bomb = new int[m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            bomb[i] = in.nextInt();
        }
        int cur = 1;
        for (int i = 0; i < m; i++) {
            if (bomb[i] == cur) {
                reset(rooms);
                int next = getNext(rooms, i, bomb, m, cur);
                if (cur != next){
                    cur = next;
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
    public static int getNext(boolean[] rooms, int start, int[] bomb, int m, int cur) {
        int pos = 0;
        for (int i = start; i < m; i++) {
            rooms[bomb[i]] = true;
            int remain = 0;
            for (int j = 1; j < rooms.length; j++) {
                if (rooms[j] == false) {
                    remain++;
                    if (remain > 1) break;
                    pos = j;
                }
            }
            if (remain == 1) break;
        }
        return pos;
    }

    public static void reset(boolean[] rooms) {
        for (int i = 1; i < rooms.length; i++) {
            rooms[i] = false;
        }
    }
}
