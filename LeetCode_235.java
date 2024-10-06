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
    TreeNode res = new TreeNode(-1);
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        if( res.val == -1 ){
            return root;
        }
        return res;
    }
    public int helper( TreeNode root, TreeNode p, TreeNode q ){
        if( root == null ){
            return -1;
        }
        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);
        if( left == -2 || right == -2 ){
            return -2;
        }
        if( ((root == p || root == q) && (right == 1 || left == 1)) || (left == 1 && right == 1)){
            res = root;
            return -2;
        }
        if( root == p || root == q || left == 1 || right == 1){
            return 1;
        }
        return -1;
    }
}