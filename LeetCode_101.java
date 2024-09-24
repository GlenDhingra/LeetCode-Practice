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
    public boolean isSymmetric(TreeNode root) 
    {
        if( root.left == null && root.right == null )
        {
            return true;
        }
        if( root.left != null )
        {
            reverseTree(root.left);  
        }
        if( root.left != null && root.right!= null )
        {
            return isSameTree(root.left,root.right);
        }
        return false;
        
        
    }
    public TreeNode reverseTree(TreeNode root)
    {
        if( root == null )
        {
            return null;
        }
        
        TreeNode left = reverseTree(root.left);
        TreeNode right = reverseTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
    
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }
}