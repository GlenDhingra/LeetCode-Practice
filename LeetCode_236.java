/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root == null) return root;
        dfs(root,p,q);
        return res;
    }
    public int dfs( TreeNode root , TreeNode p, TreeNode q )
    {
        if(root == null) return 0;
        int left = dfs(root.left,p,q);
        int right = dfs(root.right,p,q);
        if(left < 0 || right < 0) return -1;
        if( left > 0  && right > 0 )
        {
            res = root;
            return -1;
        }
        if(root == p || root == q)
        {
            if( left > 0 || right > 0 )
            {
                res = root;
                return -1;
            }
            return 1;   
        }
        return Math.max(left,right);
    }
}
/*
DFS
Return positive number if target found
if both left and right are greater than 0 or current and left OR right are greater than 0 then return that node
*/