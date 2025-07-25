class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> list = new ArrayList<>();

        // Step 1: Collect all positions with 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        // Step 2: Set corresponding rows and columns to 0
        for (int i = 0; i < list.size(); i++) {
            int[] pos = list.get(i); // use get(i) instead of list[i]
            int a = pos[0];
            int b = pos[1];

            for (int j = 0; j < m; j++) {
                matrix[j][b] = 0;
            }
            for (int j = 0; j < n; j++) {
                matrix[a][j] = 0;
            }
        }
    }
}