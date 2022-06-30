package interview;

import java.util.*;
import java.util.Queue;

public class Shopee {
    public long GetSubArrayMaxProduct(long[] nums) {
        long max = Integer.MIN_VALUE/2;
        long tempMax = 1;
        long tempMin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                long temp = tempMax;
                tempMax = tempMin;
                tempMin = temp;
            }
            tempMax = Math.max(tempMax*nums[i], nums[i]);
            tempMin = Math.min(tempMin*nums[i], nums[i]);

            max = Math.max(max, tempMax);
        }
        return max;
    }


    long count = 0;
    public long GetMinCalculateCount(long sourceX, long sourceY, long targetX, long targetY) {
//        dfs(sourceX, sourceY, targetX, targetY, 0);
        if (sourceX == targetX && sourceY == targetY) return 0;
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{sourceX, sourceY});
        int level = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                long[] temp = queue.poll();
                if (temp[0] == targetX && temp[1] == targetY) {
                    flag = true;
                    break;
                }
                else if (temp[0] < targetX && temp[1] < targetY) {
                    queue.offer(new long[]{temp[0]*2, temp[1]*2});
                    queue.offer(new long[]{temp[0]+1, temp[1]+1});
                }
            }
            if (flag) break;
            level++;
        }
        if (flag) return level;
        else return -1;
    }

    public void dfs(long sx, long sy, long tx, long ty, long count) {
        if (sx == tx && sy == ty) {
            this.count = count;
        }
        else if (sx < tx && sy < ty) {
            dfs(2*sx, 2*sy, tx, ty, count+1);
            dfs(sx+1, sy+1, tx, ty, count+1);
        }
    }

    public int calDPDScore(String dpdInfo) {
        int max = 0;
        int cnt = 0;
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < dpdInfo.length(); i++) {
            if (dpdInfo.charAt(i) == 'Y') {
                cnt++;
            }
            else if (dpdInfo.charAt(i) == 'N') {
                max = cnt > max ? cnt : max;
                cnt = 0;
            }
        }

        if (max == 0) {
            res = 0;
        }
        else if (max > 0 && max <= 3) {
            res = -10;
        }
        else if (max > 3 && max <= 7) {
            res = -15;
        }
        else if (max > 7) {
            res = -25;
        }
        return res;
    }
}
