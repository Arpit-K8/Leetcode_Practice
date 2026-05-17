class Solution {
    int[][]dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(0,0,text1,text2);
    }
    private int solve(int i, int j, String text1, String text2){
        if(i >= text1.length() || j>=text2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int take=0,skip1=0,skip2=0;
        if(text1.charAt(i) == text2.charAt(j)) take = 1 + solve(i+1,j+1,text1,text2);
        else {
            skip1 = solve(i+1,j,text1,text2);
            skip2 = solve(i,j+1,text1,text2);
        }
        return dp[i][j] = Math.max(take,Math.max(skip1,skip2));
    }
}