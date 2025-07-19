class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();

        // Step 1: Initialize distances and queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j}); // Start BFS from every 0
                } else {
                    dist[i][j] = -1; // Mark unvisited 1s
                }
            }
        }

        // Step 2: Directions for adjacency
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // Step 3: BFS traversal
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int d = 0; d < 4; d++) {
                int x = r + dx[d];
                int y = c + dy[d];
                if (x >= 0 && y >= 0 && x < rows && y < cols && dist[x][y] == -1) {
                    dist[x][y] = dist[r][c] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return dist;
    }
}