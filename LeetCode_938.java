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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }
    public int dfs( TreeNode root, int low, int high ){
        int sum = 0;
        if( root == null ){
            return 0;
        }
        int val = root.val;
        if( val >= low && val <= high ){
            sum += val;
        }
        if( val <= low ){
            sum += dfs(root.right, low, high);
        }
        else if( val >= high ){
            sum += dfs(root.left, low, high);
        }
        else{
            sum += dfs(root.left, low, high);
            sum += dfs(root.right, low, high);
        }
        return sum;
    }
}
