class Solution {
    int m, n, N;
    int[][][] dp; 
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();n = s2.length();N = s3.length();
        if (m + n != N) return false; 
        dp = new int[101][101][201];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 201; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(0, 0, 0, s1, s2, s3);
    }
    public boolean solve(int i, int j, int k, String s1, String s2, String s3) {
        
        if (i == m && j == n && k == N) return true;
        if (k >= N) return false;  // s3 finished but s1 or s2 not finished
        
        if (dp[i][j][k] != -1) {
            return dp[i][j][k] == 1;
        }
        boolean result = false;
        if (i < m && s1.charAt(i) == s3.charAt(k)) {
            result = solve(i + 1, j, k + 1, s1, s2, s3);
        }
        if (!result && j < n && s2.charAt(j) == s3.charAt(k)) {
            result = solve(i, j + 1, k + 1, s1, s2, s3);
        }
        dp[i][j][k] = result ? 1 : 0;
        return result;
    }
    
}