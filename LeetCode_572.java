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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        return dfs(root,subRoot);
    }
    public boolean dfs( TreeNode root , TreeNode subRoot )
    {
        if( root == null )
        {
            return false;
        }
        boolean res = false;
        if( root.val == subRoot.val )
        {
            res = helper(root,subRoot);
        }
        if( res == true )
        {
            return res;
        }
        return res || dfs(root.left,subRoot) || dfs(root.right,subRoot);
        
    }
    public boolean helper( TreeNode root , TreeNode subRoot )
    {
        if( root == null && subRoot == null )
        {
            return true;
        }
        if( root == null || subRoot == null )
        {
            return false;
        }
        if( root.val != subRoot.val )
        {
            return false;
        }
        return helper(root.left,subRoot.left) && helper(root.right,subRoot.right);
    }
}