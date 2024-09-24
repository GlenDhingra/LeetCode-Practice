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
    int sum = 0;
    public int findTilt(TreeNode root) 
    {
        int ans = helper(root);
        return sum;
    }
    public int helper( TreeNode root )
    {
        if( root == null )
        {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        
        int val = root.val;
        root.val = Math.abs(left - right);
        sum += root.val;
        return left + right + val;
    }
}