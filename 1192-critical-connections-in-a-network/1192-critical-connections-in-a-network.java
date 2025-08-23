class Solution {
    private int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> conn : connections){
            int u = conn.get(0), v = conn.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] disc = new int[n]; // Discovery time
        int[] low = new int[n];  // Lowest reachable time
        Arrays.fill(disc, -1);   // Unvisited nodes
        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, disc, low, adj, bridges);
        return bridges;
    }

    private void dfs(int u, int parent, int[] disc, int[] low, List<List<Integer>> adj, List<List<Integer>> bridges){
        disc[u] = low[u] = time++;
        for(int v : adj.get(u)){
            if(v == parent) continue; // Skip the edge to parent

            if(disc[v] == -1){ // If v is not visited
                dfs(v, u, disc, low, adj, bridges);
                low[u] = Math.min(low[u], low[v]);

                if(low[v] > disc[u]){ // Bridge condition
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]); // Back edge
            }
        }
    }
}