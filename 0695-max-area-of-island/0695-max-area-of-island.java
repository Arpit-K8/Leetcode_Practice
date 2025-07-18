class Solution {
    int size = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    size = 0; // Reset before each DFS
                    DFS(grid, i, j, r, c);
                    maxArea = Math.max(maxArea, size);
                }
            }
        }
        return maxArea;
    }
    void DFS(int[][] grid, int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] == 0) return;
        grid[i][j] = 0;
        size++;
        DFS(grid, i, j + 1, r, c); // Right
        DFS(grid, i - 1, j, r, c); // Up
        DFS(grid, i, j - 1, r, c); // Left
        DFS(grid, i + 1, j, r, c); // Down
    }
}