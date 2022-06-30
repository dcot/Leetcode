package interview;

import java.util.Scanner;

public class bianlifeng {
    public  void robbery() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] chs = line.split(",");
            int[] nums = new int[chs.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(chs[i]);
            }
            int[][] dp = new int[nums.length][2];
            dp[0][1] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
                dp[i][1] = dp[i-1][0]+nums[i];
            }
            System.out.println(Math.max(dp[nums.length-1][0], dp[nums.length-1][1]));
        }
    }
}
