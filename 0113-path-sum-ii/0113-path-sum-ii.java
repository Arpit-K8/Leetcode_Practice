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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp_res = new ArrayList<>();
        Preorder(root, 0, targetSum, res, temp_res);
        return res;
    }
    private void Preorder(TreeNode root, int curr, int k, List<List<Integer>> res, List<Integer> temp_res) {
        if (root == null) return;

        curr += root.val;
        temp_res.add(root.val);

        if (root.left == null && root.right == null && curr == k) {
            res.add(new ArrayList<>(temp_res)); // Make a copy before adding
        }

        Preorder(root.left, curr, k, res, temp_res);
        Preorder(root.right, curr, k, res, temp_res);

        temp_res.remove(temp_res.size() - 1); // Backtrack
    }
}