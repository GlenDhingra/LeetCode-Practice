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
    public TreeNode constructMaximumBinaryTree(int[] nums) 
    {    
        if( nums.length == 0 )
        {
            return null;
        }
        int max = nums[0];
        int maxIndex = 0;
        for( int i = 0 ; i < nums.length ; i++ )
        {
            if( nums[i] > max )
            {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode();
        root.val = max;
        root.left = constructMaximumBinaryTree( Arrays.copyOfRange(nums,0,maxIndex) );
        root.right = constructMaximumBinaryTree( Arrays.copyOfRange(nums,maxIndex+1,nums.length));
        return root;
    }
}