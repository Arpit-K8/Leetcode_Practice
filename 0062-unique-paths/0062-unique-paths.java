class Solution {
    int[][] dp;
    int lastrow,lastcol;
    int count = 0;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        lastrow = m;lastcol = n;
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0);
    }
    public int solve(int row,int col){
        if(row == lastrow && col == lastcol) return 0;
        if(row == lastrow-1 || col == lastcol-1) return 1; //reached
        if(dp[row][col]!=-1) return dp[row][col];
        int right = solve(row,col+1);
        int down = solve(row+1,col);
        return dp[row][col] = right+down;
    }
}