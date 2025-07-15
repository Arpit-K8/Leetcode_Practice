class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = new StringBuilder(s).reverse().toString(); // Correct reverse logic
        int size = s.length();

        int[][] dp = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (s.charAt(i - 1) == s1.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[size][size];
    }
}