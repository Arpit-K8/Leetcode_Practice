class Solution {
    int M,N;
    int dp[][];
    public int solve(String s1, String s2, int i, int j) {
        if (i >= M && j >= N) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (i >= M) return dp[i][j] = s2.charAt(j) + solve(s1, s2, i, j + 1);
        if (j >= N) return dp[i][j] = s1.charAt(i) + solve(s1, s2, i + 1, j);
        if (s1.charAt(i) == s2.charAt(j)) return dp[i][j] = solve(s1, s2, i + 1, j + 1);

        int deleteFromS1 = s1.charAt(i) + solve(s1, s2, i + 1, j);
        int deleteFromS2 = s2.charAt(j) + solve(s1, s2, i, j + 1);
        return dp[i][j] = Math.min(deleteFromS1, deleteFromS2);
    }
    public int minimumDeleteSum(String s1, String s2) {
        M = s1.length();
        N = s2.length();
        dp = new int[M + 1][N + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(s1, s2, 0, 0);
    }
}