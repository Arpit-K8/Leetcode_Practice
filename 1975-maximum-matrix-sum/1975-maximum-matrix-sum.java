class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        long sum = 0;
        int count = 0; // countNegatives
        int leastAbsolute = Integer.MAX_VALUE; // smallestAbsoluteValue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.abs(matrix[i][j]);
                if (matrix[i][j] < 0) count++;
                leastAbsolute = Math.min(leastAbsolute, Math.abs(matrix[i][j]));
            }
        }
        if (count % 2 == 0) return sum;
        return sum - 2*leastAbsolute;
    }
}