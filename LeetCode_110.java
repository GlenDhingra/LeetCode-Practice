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
    public boolean isBalanced(TreeNode root) {
        int res = dfs(root);
        if( res == -1 ){
            return false;
        } 
        return true;
    }
    public int dfs( TreeNode root ){
        if( root == null ){
            return 0;
        }
        int subTree1 = dfs(root.left);
        if( subTree1 == -1 ){
            return -1;
        }
        int subTree2 = dfs(root.right);
        if( subTree2 == -1 ){
            return -1;
        }
        int res = Math.abs(subTree1 - subTree2);
        if( res > 1 ){
            return -1;
        }
        return Math.max(subTree1, subTree2) + 1;
    }
}