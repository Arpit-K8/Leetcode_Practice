class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
    private int solve(int target){
        if(target == 0) return 0;
        if(target < 0) return Integer.MAX_VALUE;
        if(dp[target] != -1) return dp[target];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i*i <= target; i++){
            int res = solve(target - i*i);
            if(res != Integer.MAX_VALUE) min = Math.min(min, res +1);
        }
        return dp[target] = min;
    }
}