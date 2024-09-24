/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) 
    {
        dfs(original,target,cloned);
        return ans;
    }
    public void dfs( TreeNode root , TreeNode target ,TreeNode clone )
    {
        if(root == null) 
            return;
        if( root == target )
            ans = clone;
        dfs(root.left,target,clone.left);
        dfs(root.right,target,clone.right);
    }
    
}