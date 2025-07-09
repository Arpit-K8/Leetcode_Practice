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
    int max = 0;
    public int maxDepth(TreeNode root) {
        int count = 0; 
        Preorder(root,count);
        return max;
    }
    private void Preorder(TreeNode root,int count){
        if(root == null) return;
        count++;
        if(root.left == null || root.right == null){
            if(max<count) max = count;
        }
        Preorder(root.left,count);
        Preorder(root.right,count);
    }
}