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
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        TreeNode root = new TreeNode(preorder[0]);   
        for( int i = 1 ; i < preorder.length ; i++ )
        {
            addNode(root,preorder[i]);
        }
        return root;
    }
    public void addNode( TreeNode root,int val )
    {
        TreeNode temp = root;
        TreeNode par = root;
        while( temp != null )
        {
            par = temp;
            if( val <= temp.val )
            {
                temp = temp.left;
            }
            else
            {
                temp = temp.right;
            }
        }
        if( val <= par.val )
        {
            par.left = new TreeNode(val);
        }
        else
        {
            par.right = new TreeNode(val);
        }
    }
}