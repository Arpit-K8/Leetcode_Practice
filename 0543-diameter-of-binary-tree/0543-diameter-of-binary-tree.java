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
    private int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return result-1;
    }
    private int height(TreeNode root){
        if(root == null) return 0;
        
        int leftnode = height(root.left);
        int rightnode = height(root.right);
        result = Math.max(result,leftnode+rightnode+1);
        return Math.max(leftnode,rightnode)+1;
    }
}
