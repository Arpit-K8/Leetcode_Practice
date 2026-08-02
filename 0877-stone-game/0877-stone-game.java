class Solution {
    int[][] dp = new int[501][501];
    public boolean stoneGame(int[] piles) {
        for(int[] row : dp) Arrays.fill(row,-1);
        int sum =0;
        for(int p:piles){
            sum+=p;
        }
        int n = piles.length;
        int alexScore = solve(piles,0,n-1);
        return alexScore > sum/2;
    }
    private int solve(int [] arr, int i , int j){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int chooseI = arr[i] + Math.min(solve(arr,i+2,j),solve(arr,i+1,j-1));  
        int chooseJ = arr[j] + Math.min(solve(arr,i,j-2),solve(arr,i+1,j-1));

        return dp[i][j] = Math.max(chooseI,chooseJ);
    }
}