class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int max = 0;
        int rowIndex = 0;
        for (int i = 0; i < m; i++) {
            int count = 0;  
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) count++;
            }
            if (count > max) {
                max = count;
                rowIndex = i;
            }
        }
        return new int[]{rowIndex, max};
    }
}
