class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        dp = new int[n];
        Arrays.fill(dp,-1);
        int case1 = solve(0, n-2, nums); // skip last house
        
        dp = new int[n];
        Arrays.fill(dp,-1);
        int case2 = solve(1, n-1, nums); // skip first house
        return Math.max(case1, case2);
    }
    private int solve(int i, int end, int[] nums){
        if(i > end) return 0;
        if(dp[i] != -1) return dp[i];
        int steal = nums[i] + solve(i+2, end, nums);
        int skip = solve(i+1, end, nums);
        return dp[i] = Math.max(steal, skip);
    }
}