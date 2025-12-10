class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(hasCycle(adj, visited, i)) return false;
            }
        }
        return true;
    }
    private boolean hasCycle(List<List<Integer>> adj, int[] visited, int node){
        if(visited[node] == 1) return true;   // found a cycle
        if(visited[node] == 2) return false;  // already processed
        visited[node] = 1; // mark as visiting
        for(int nei : adj.get(node)){
            if(hasCycle(adj, visited, nei)) return true;
        }
        visited[node] = 2; // mark as visited
        return false;
    }
}