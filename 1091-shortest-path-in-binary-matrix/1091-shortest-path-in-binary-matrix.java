class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 0) return -1;
        int m = grid[0].length;

        // Check if start or end cell is blocked
        if (grid[0][0] != 0 || grid[n - 1][m - 1] != 0) return -1;

        // Directions for 8 neighbors
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        // BFS setup
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        grid[0][0] = 1;  // Use grid to track distance

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];
            int dist = grid[row][col];

            // Check if we've reached the bottom-right
            if (row == n - 1 && col == m - 1) return dist;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    grid[newRow][newCol] == 0) {

                    q.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = dist + 1;
                }
            }
        }

        return -1;  // No path found
    }
}