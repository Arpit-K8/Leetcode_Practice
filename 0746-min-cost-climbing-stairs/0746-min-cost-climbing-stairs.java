class Solution {
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // cause i can start form 0 or 1 
        return Math.min(solve(cost, 0, n), solve(cost, 1, n));
    }

    private int solve(int[] arr, int i, int n) {
        if (i >= n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        return dp[i] = arr[i] + Math.min(solve(arr, i + 1, n), solve(arr, i + 2, n));
    }
}