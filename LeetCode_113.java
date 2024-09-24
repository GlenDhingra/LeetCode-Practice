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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(root,res,curr,0,targetSum);
        return res;
    }
    public void backtrack( TreeNode root,List<List<Integer>> res, List<Integer> curr , int sum ,int target)
    {
        if( root == null )
            return;
        sum = sum + root.val;
        curr.add(root.val);
        if( root.left == null && root.right == null && sum == target )
        {
            res.add(new ArrayList<>(curr));
            curr.remove( curr.size() - 1 );
            return;
        }
        backtrack(root.left,res,curr,sum,target);        
        backtrack(root.right,res,curr,sum,target);
        curr.remove( curr.size() - 1 );
        return;
    }
}