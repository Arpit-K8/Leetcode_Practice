class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int u = edge[0]; 
            int v = edge[1]; 
            adj.get(v).add(u); 
            indegree[u]++;     
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            order[index++] = course;
            for (int neighbor : adj.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        if (index == numCourses) return order;
        else return new int[0];
    }
}