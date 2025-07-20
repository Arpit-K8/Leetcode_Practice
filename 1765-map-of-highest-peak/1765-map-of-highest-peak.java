class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        int[][] height = new int[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    height[i][j] = -1; // unvisited land
                }
            }
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int d = 0; d < 4; d++) {
                int x = r + dx[d];
                int y = c + dy[d];

                if (x >= 0 && y >= 0 && x < rows && y < cols && height[x][y] == -1) {
                    height[x][y] = height[r][c] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return height;
    }
}