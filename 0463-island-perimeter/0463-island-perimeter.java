class Solution {
    private int count = 0;
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return count;
                }
            }
        }
        return 0;
    }
    private void dfs(int[][] grid, int i, int j) {
        int rows = grid.length, cols = grid[0].length;
        if (i < 0 || j < 0 || i == rows || j == cols || grid[i][j] == 0) {
            count++;
            return;
        }
        if (grid[i][j] == -1) return; // Already visited
        grid[i][j] = -1;  // Mark as visited

        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
}