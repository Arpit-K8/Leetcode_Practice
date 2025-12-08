/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    private Map<Node, Node> map = new HashMap<>();
    private void dfs(Node node, Node cloneNode) {
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                Node clone = new Node(neighbor.val);
                map.put(neighbor, clone);
                cloneNode.neighbors.add(clone);

                dfs(neighbor, clone);
            } else {
                cloneNode.neighbors.add(map.get(neighbor));
            }
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        map.clear();
        // Clone the starting node
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        // DFS to clone neighbors
        dfs(node, cloneNode);
        return cloneNode;
    }
}