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
class Solution 
{
    public boolean hasPathSum(TreeNode root, int targetSum) 
    {
        return dfs(root,0,targetSum);
    }
    public boolean dfs(TreeNode root , int curr,int target)
    {
        if(root == null) return false;
        curr += root.val;
        if(curr == target && root.left == null && root.right == null) return true;
        return dfs(root.left,curr,target) || dfs(root.right,curr,target);
    }
}