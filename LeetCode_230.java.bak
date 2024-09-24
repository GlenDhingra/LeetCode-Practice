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
    public int kthSmallest(TreeNode root, int k) 
    {
        HashSet<Integer> set = new HashSet<>();
        dfs(root,set);
        Iterator itr = set.iterator();
        for( int i = 1 ; i < k ; i++ )
        {
            itr.next();
        }
        return (int)itr.next();
    }
    public void dfs( TreeNode root ,HashSet<Integer> set )
    {
        if( root == null )
        {
            return;
        }
        set.add(root.val);
        dfs(root.left,set);
        dfs(root.right,set);
    }
}