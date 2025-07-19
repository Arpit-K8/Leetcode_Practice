class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        // Push all initially rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0; // No fresh oranges to rot
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] node = queue.poll();
                int r = node[0], c = node[1];

                for (int i = 0; i < 4; i++) {
                    int x = r + dx[i];
                    int y = c + dy[i];

                    if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        fresh--;
                    }
                }
            }
            if (!queue.isEmpty()) time++;
        }
        return fresh == 0 ? time : -1;
    }
}