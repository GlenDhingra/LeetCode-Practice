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
    public int findSecondMinimumValue(TreeNode root) 
    {
        ArrayList<Integer> list = new ArrayList();
        dfs(root,list);
        if( list.size() == 1 )
        {
            return -1;
        }
        Collections.sort(list);
        return list.get(1);
        
    }
    public void dfs( TreeNode root,ArrayList<Integer> list)
    {
        if( root == null )
        {
            return;
        }
        if( !list.contains(root.val) )
        {
            list.add(root.val);   
        }
        dfs(root.left,list);
        dfs(root.right,list);
        return;
    }
}