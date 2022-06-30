package interview;

import java.util.Scanner;

public class NetEase {
    public static char lastNum = 'u';
    public static int res = 0;
    public static int[] weights = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
    public static char[] maps = {'1','0','X','9','8','7','6','5','4','3','2'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.length() != 18) continue;
            res = 0;
            char[] ids = line.toCharArray();
            int sum = 0;
            lastNum = ids[17];
            for (int j = 0; j < 14; j++) {
                if (Character.isDigit(ids[j])) {
                    int temp = ids[j] - '0';
                    sum += temp*weights[j];
                }
            }
            char[] subIds = line.substring(14,17).toCharArray();
            dfs(subIds, 0, sum);
            System.out.println(res);
        }
    }
    /*
    2
34088119480815***3
34088119480815**23
340881194808152*53
520123200501169**4
5201232005011691*X
52012320050116*1*X
52012320050116*15X
99999999999999***9
     */
    public static void dfs(char[] subIds, int index, int sum) {
        if (index > 2) {
            int a = subIds[0] - '0';
            int b = subIds[1] - '0';
            int c = subIds[2] - '0';
            int temp = (sum + a*weights[14] + b*weights[15] + c*weights[16]);
            int remain = temp % 11;
            if (remain < 0 || remain > maps.length) return;
            if (maps[remain] == lastNum) res++;
            return;
        }
        else {
            if (Character.isDigit(subIds[index])) {
                dfs(subIds, index+1, sum);
            }
            else {
                for (int i = 0; i < 10; i++) {
                    subIds[index] = (char)(i + '0');
                    dfs(subIds, index+1, sum);
                    subIds[index] = '*';
                }
            }
        }
    }
    public  void brusher() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            in.nextLine();
            String line = in.nextLine();
            char[] colors = line.toCharArray();
            int rcnts = 0;
            int bcnts = 0;
            char last;
            int index = -1;
            if (n == 1) {
                System.out.println(1);
            }
            else {
                for (int i = 0; i < n-1; i++) {
                    if (colors[i] != colors[i+1] && colors[i] == 'B') {
                        bcnts++;
                        index = i;
                    }
                    else if (colors[i] != colors[i+1] && colors[i] == 'R') {
                        rcnts++;
                        index = i;
                    }
                }
                if (colors[n-1] == 'B' && index != -1) {
                    bcnts++;
                }
                else if (colors[n-1] == 'R' && index != -1){
                    rcnts++;
                }
                System.out.println(rcnts > bcnts ? bcnts+1 : rcnts+1);
            }
        }
    }
    public void maxMutiTimes() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()) {
            long a = in.nextInt();
            long b = in.nextInt();
            int[] factors = {2, 3, 5, 7};
            if (b % a == 0) {
                int cnt = 0;
                b /= a;
                while (b > a) {
                    for (int i = 0; i < 4; i++) {
                        if (b % factors[i] == 0) {
                            b /= factors[i];
                            cnt++;
                        }
                    }
                }
                System.out.println(cnt);
            } else {
                System.out.println(-1);
            }
        }
    }
}
