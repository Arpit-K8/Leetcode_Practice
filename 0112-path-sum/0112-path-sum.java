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
    int total = 0;
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        preOrder(root, 0, targetSum);
        return flag;
    }
    private void preOrder(TreeNode root, int currSum, int targetSum) {
        if (root == null) return;
        currSum += root.val;
        if (root.left == null && root.right == null && currSum == targetSum) {
            flag = true;
            return;
        }
        preOrder(root.left, currSum, targetSum);
        preOrder(root.right, currSum, targetSum);
    }
}