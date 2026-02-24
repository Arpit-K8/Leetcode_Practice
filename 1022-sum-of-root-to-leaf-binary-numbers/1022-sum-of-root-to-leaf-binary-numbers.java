class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int current) {
        if (root == null) return 0;
        // build binary number
        current = current * 2 + root.val;
        if (root.left == null && root.right == null) return current;
        return dfs(root.left, current) + dfs(root.right, current);
    }
}