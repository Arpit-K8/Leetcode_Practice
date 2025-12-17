class Solution {
    private List<Integer>[] adj;
    private int[] present;
    private int[] future;
    private int budget;
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.present = present;
        this.future = future;
        this.budget = budget;
        this.adj = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : hierarchy) {
            adj[edge[0] - 1].add(edge[1] - 1);
        }
        return dfs(0)[0][budget];
    }
    private int[][] dfs(int u) {
        int[] currentSkip = new int[budget + 1];
        int[] currentBuy = new int[budget + 1];

        for (int v : adj[u]) {
            int[][] childRes = dfs(v);
            int[] nextSkip = new int[budget + 1];
            int[] nextBuy = new int[budget + 1];

            for (int b = 0; b <= budget; b++) {
                for (int k = 0; k <= b; k++) {
                    nextSkip[b] = Math.max(nextSkip[b], currentSkip[b - k] + childRes[0][k]);
                    nextBuy[b] = Math.max(nextBuy[b], currentBuy[b - k] + childRes[1][k]);
                }
            }
            currentSkip = nextSkip;
            currentBuy = nextBuy;
        }

        int[][] res = new int[2][budget + 1];
        int cost = present[u];
        int discountCost = cost / 2;
        int profit = future[u] - cost;
        int discountProfit = future[u] - discountCost;

        for (int b = 0; b <= budget; b++) {
            res[0][b] = currentSkip[b];
            if (b >= cost) {
                res[0][b] = Math.max(res[0][b], currentBuy[b - cost] + profit);
            }
            res[1][b] = currentSkip[b];
            if (b >= discountCost) {
                res[1][b] = Math.max(res[1][b], currentBuy[b - discountCost] + discountProfit);
            }
        }
        return res;
    }
}