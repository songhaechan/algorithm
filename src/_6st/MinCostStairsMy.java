package _6st;

public class MinCostStairsMy {
    public int minCostClimbingStairs(int[] cost) {
        int[][] dp = new int[2][cost.length];
        dp[0][0] = cost[0];
        dp[0][1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[0][i] = Math.min(dp[0][i - 2] + cost[i], dp[0][i - 1] + cost[i]);
        }
        dp[1][0] = 10000;
        dp[1][1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            if (cost.length - 1==i) {
                dp[1][cost.length - 1] = dp[1][cost.length - 2];
            } else {
                dp[1][i] = Math.min(dp[0][i - 2] + cost[i], dp[0][i - 1] + cost[i]);
            }
        }
        return Math.min(dp[0][cost.length - 1], dp[1][cost.length - 1]);
    }
}
