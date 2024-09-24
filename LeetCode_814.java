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
    public TreeNode pruneTree(TreeNode root) 
    {
        dfs(root);
        if( root.val == 0 && root.left == null && root.right == null ) return null;
        return root;
    }
    public int dfs( TreeNode root )
    {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == 0) root.left = null;
        if(right == 0) root.right = null;
        if( root.val == 1 || left == 1 || right == 1 )
        {
            return 1;
        }
        return 0;
    }
}