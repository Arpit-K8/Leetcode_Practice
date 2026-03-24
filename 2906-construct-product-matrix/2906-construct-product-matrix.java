class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 12345;
        int s = m*n;
        int[] flat = new int[s];
        int k = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                flat[k] = grid[i][j] % mod;
                k++;
            }
        }
        int[] prefix = new int[s];
        prefix[0] = 1;
        for(int i = 1; i < s; i++){
            prefix[i] = (prefix[i-1]*flat[i-1]) % mod;
        }
        int[] suffix = new int[s];
        suffix[s-1] = 1;
        for(int i = s-2; i >= 0; i--){
            suffix[i] = (suffix[i+1] * flat[i+1]) % mod;
        }
        int[][] result = new int[m][n];
        k = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = (prefix[k] * suffix[k]) % mod;
                k++;
            }
        }
        return result;
    }
}