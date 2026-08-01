class Solution {
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int n = graph.length;
        for(int i =0;i<n;i++) adj.put(i, new ArrayList<>());
        for (int i = 0; i < n; i++) { 
            // here graph[i] already contains all neighbours of node i.
            for (int neigh : graph[i]) {
                adj.get(i).add(neigh);
            }
        }
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if (checkBipDFS(adj,i,color,1) == false) return false;
            } 
        }
        return true;
    }
    private boolean checkBipDFS(HashMap<Integer, ArrayList<Integer>> adj, int curr, int[] color, int currColor){
        color[curr] = currColor; // first color done
        for(int neigh: adj.get(curr)){
            if(color[neigh]==color[curr]) return false;
            if(color[neigh] == -1){
                int colorofV = 1-currColor;
                
                if(checkBipDFS(adj, neigh, color, colorofV) == false) return false;
            }
        }
        return true;
    }
}
