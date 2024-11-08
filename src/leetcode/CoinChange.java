package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        boolean[] visited = new boolean[amount + 1];

        Queue<Pair> que = new ArrayDeque<>();
        que.offer(new Pair(amount,0));
        while (!que.isEmpty()) {
            Pair removed = que.poll();
            for (int i = 0; i < coins.length; i++) {
                int remainAmount = removed.amount - coins[i];
                if (remainAmount == 0) {
                    return removed.count+1;
                }
                if (remainAmount > 0 && !visited[remainAmount]) {
                    que.offer(new Pair(remainAmount,removed.count+1));
                    visited[remainAmount] = true;
                }
            }
        }
        return -1;
    }
    static class Pair{
        int amount;
        int count;
        Pair(int amount, int count){
            this.amount = amount;
            this.count  = count;
        }
    }

}
