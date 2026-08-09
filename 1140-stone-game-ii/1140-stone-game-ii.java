class Solution {
    private int n;
    private int[][][] dp = new int[2][101][101]; // dp[2][n+1][n+1] 
    public int stoneGameII(int[] piles) {
        n = piles.length;
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        return solve(piles, 1, 0, 1);
    }
    private int solve(int[] piles, int person, int i, int M) {
        if (i >= n) return 0;
        if (dp[person][i][M] != -1) return dp[person][i][M];
        
        int res = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;
        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {
            stones += piles[i + x - 1];
            
            if (person == 1) { // Alice
                res = Math.max(res, stones + solve(piles, 0, i + x, Math.max(M, x)));
            } else { // Bob
                res = Math.min(res, solve(piles, 1, i + x, Math.max(M, x)));
            }
        }
        return dp[person][i][M] = res;
    }
    
}