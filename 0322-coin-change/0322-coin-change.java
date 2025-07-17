class Solution {
    public int coinChange(int[] coins, int target) {
        int n = coins.length;
        int INF = (int) 1e9;  // Large value to simulate unreachable
        int[][] dp = new int[n + 1][target + 1];
        // Initialize base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // 0 amount needs 0 coins
        }
        for (int j = 1; j <= target; j++) {
            dp[0][j] = INF; // Can't make positive amount with 0 coins
        }
        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= target; j++) {
                if (coin <= j) {
                    dp[i][j] = Math.min(
                        dp[i - 1][j],           // skip this coin
                        1 + dp[i][j - coin]     // pick this coin (unbounded)
                    );
                } else {
                    dp[i][j] = dp[i - 1][j]; // can't pick this coin
                }
            }
        }

        return dp[n][target] == INF ? -1 : dp[n][target];
    }
}