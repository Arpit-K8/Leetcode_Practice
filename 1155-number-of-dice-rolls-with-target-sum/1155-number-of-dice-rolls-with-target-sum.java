class Solution {
    int[][] dp;
    int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(n, k, target);
    }
    private int solve(int n, int k, int sum){
        if(n == 0 && sum == 0) return 1;
        if(n == 0 || sum < 0) return 0;

        if(dp[n][sum] != -1) return dp[n][sum];
        int ways = 0;
        for(int i = 1; i <= k; i++){
            ways = (ways + solve(n-1, k, sum-i)) % MOD; // for negative one we need mod
        }
        return dp[n][sum] = ways;
    }
}