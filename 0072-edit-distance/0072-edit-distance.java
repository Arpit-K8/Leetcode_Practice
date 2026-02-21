class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m + 1][n + 1];
        // Fill with -1 (means not computed yet)
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(word1, word2, m, n);
    }
    private int solve(String w1, String w2, int i, int j) {        
        // Base cases
        if (i == 0) return j;
        if (j == 0) return i;
        // If already computed
        if (dp[i][j] != -1) return dp[i][j];
        // If characters match
        if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
            dp[i][j] = solve(w1, w2, i - 1, j - 1);
        } 
        else {
            int replace = solve(w1, w2, i - 1, j - 1);
            int delete = solve(w1, w2, i - 1, j);
            int insert = solve(w1, w2, i, j - 1);
            dp[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
        }
        return dp[i][j];
    }
}