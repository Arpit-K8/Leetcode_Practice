class Solution { // memo+rec
    // int[][] dp;
    // int lastrow,lastcol;
    // int count = 0;
    // public int uniquePaths(int m, int n) {
    //     dp = new int[m+1][n+1];
    //     lastrow = m;lastcol = n;
    //     for(int[] row : dp){
    //         Arrays.fill(row,-1);
    //     }
    //     return solve(0,0);
    // }
    // public int solve(int row,int col){
    //     if(row == lastrow && col == lastcol) return 0;
    //     if(row == lastrow-1 || col == lastcol-1) return 1; //reached
    //     if(dp[row][col]!=-1) return dp[row][col];
    //     int right = solve(row,col+1);
    //     int down = solve(row+1,col);
    //     return dp[row][col] = right+down;
    // }

    // bottom up
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, 1);
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}