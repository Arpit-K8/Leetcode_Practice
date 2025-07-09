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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        Preorder(root,"",res);
        return res;
    }
    private void Preorder(TreeNode node, String path, List<String> res){
        if(node == null) return;
        if(path.isEmpty()) path+=Integer.toString(node.val);
        else path+="->"+Integer.toString(node.val);
        if(node.left == null && node.right == null) {
            res.add(path);
            return;
        }
        Preorder(node.left,path,res);
        Preorder(node.right,path,res);
    }
}