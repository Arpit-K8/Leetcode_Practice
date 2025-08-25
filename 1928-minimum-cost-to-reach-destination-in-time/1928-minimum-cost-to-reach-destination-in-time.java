class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], t = edge[2];
            adj.get(u).add(new int[]{v, t});
            adj.get(v).add(new int[]{u, t});
        }
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{passingFees[0], 0, 0}); // cost, time, node
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int cost = top[0], time = top[1], node = top[2];
            if (node == n - 1) return cost;
            for (int[] neighbor : adj.get(node)) {
                int next = neighbor[0], travelTime = neighbor[1];
                int newTime = time + travelTime;
                int newCost = cost + passingFees[next];
                if (newTime <= maxTime && newTime < minTime[next]) {
                    minTime[next] = newTime;
                    pq.add(new int[]{newCost, newTime, next});
                }
            }
        }
        return -1; 
    }
}