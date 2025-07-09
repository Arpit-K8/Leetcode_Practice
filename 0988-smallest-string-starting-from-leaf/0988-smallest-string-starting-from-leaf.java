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
    public String smallestFromLeaf(TreeNode root) {
        List<String> res = new ArrayList<>();
        Preorder(root, "", res);
        Collections.sort(res);
        return res.get(0);
    }

    private void Preorder(TreeNode root, String path, List<String> res) {
        if (root == null) return;
        // Convert value to character and prepend
        path = (char)(root.val + 'a') + path;
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        Preorder(root.left, path, res);
        Preorder(root.right, path, res);
    }
}