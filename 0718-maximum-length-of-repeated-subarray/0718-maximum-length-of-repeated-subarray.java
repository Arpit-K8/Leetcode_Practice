class Solution {
    public int findLength(int[] s1, int[] s2) {
        int m = s1.length;
        int n = s2.length;
        int[][] dp = new int[m+1][n+1];
        int ans = 0;
        for(int i = 1;i<=m;i++){
            for(int j = 1 ;j<=n; j++){
                if(s1[i-1] == s2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans,dp[i][j]); 
                }
                else dp[i][j] = 0;
            }
        }
        return ans;
    }
}