/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        getLeafNodes(root1, res1);
        getLeafNodes(root2, res2);
        return res1.equals(res2);
    }

    private void getLeafNodes(TreeNode node, List<Integer> res) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            res.add(node.val); 
            return;
        }

        getLeafNodes(node.left, res);
        getLeafNodes(node.right, res);
    }
}