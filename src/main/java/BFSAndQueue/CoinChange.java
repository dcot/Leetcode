package BFSAndQueue;

import java.util.*;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int level = 0;
        int length = coins.length;
        Arrays.sort(coins);
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int sum = queue.poll();
                for (int j = 0; j < length; j++) {
                    if (sum + coins[j] == amount) {
                        return level;
                    } else if (sum + coins[j] < amount) {
                        if (!visited.contains(sum + coins[j])) {
                            queue.offer(sum + coins[j]);
                            visited.add(sum + coins[j]);
                        }
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return -1;
    }
}
