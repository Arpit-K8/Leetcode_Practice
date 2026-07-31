class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++) adj.put(i,new ArrayList<>());
        for(int[] edge :prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u); // b->a thats why we need to do like this
            indegree[u]++;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int cnt=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;
            for(int neigh : adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0) q.offer(neigh);
            }
        }
        return cnt == numCourses;
    }
}