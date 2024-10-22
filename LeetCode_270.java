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
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        double i = Math.abs(target-min);
        double j = Math.abs(target-max);
        if( j <= i ){
            return max;
        }
        return min;
    }
    public void helper( TreeNode root, double target ){
        if( root == null ){
            return;
        }
        if( root.val <= target ){
            max = Math.max(root.val, max);
            helper(root.right, target);
        }
        else{
            min = Math.min(root.val, min);
            helper(root.left, target);
        }
    }
}