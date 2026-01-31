class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = getMaxRow(mat, mid);
            if (isPeak(mat, row, mid)) {
                return new int[]{row, mid};
            }
            // Move towards bigger neighbor
            if (mid + 1 < n && mat[row][mid + 1] > mat[row][mid]) left = mid + 1;
            else right = mid - 1;
        }
        return new int[]{-1, -1};
    }
    // Find row index having max value in column
    private int getMaxRow(int[][] mat, int col) {
        int maxRow = 0;
        for (int i = 1; i < mat.length; i++) {
            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }
    // Check if it's a peak
    private boolean isPeak(int[][] mat, int row, int col) {
        int m = mat.length;
        int n = mat[0].length;

        int left = (col - 1 >= 0) ? mat[row][col - 1] : -1;
        int right = (col + 1 < n) ? mat[row][col + 1] : -1;

        return mat[row][col] > left && mat[row][col] > right;
    }
}
