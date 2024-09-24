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
    int count = 0;
    public int goodNodes(TreeNode root) 
    {
        helper( root , root.val );
        return count;
    }
    public void helper( TreeNode root , int greater )
    {
        if( root == null )
        {
            return;
        }
        if( root.val >= greater )
        {
            greater = root.val;
            count++;
        }
        helper( root.left , greater );
        helper( root.right , greater );
    }
}
/*
Inorder Traversal
Pass the greater value at each level and check if the current node is >= the greater value
if yes then set greater to the current node's value and increment count
*/