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
class Solution 
{
    public int maxLevelSum(TreeNode root) 
    {
        Queue<TreeNode> queue = new LinkedList<>();
        int max = root.val;
        int level = 1;
        int res = 1;
        queue.offer(root);
        while( !queue.isEmpty() )
        {
            int size = queue.size();
            int currSum = 0;
            for( int i = 0 ; i < size ; i++ )
            {
                TreeNode curr = queue.poll();
                currSum += curr.val;
                if( curr.left != null )
                {
                    queue.offer(curr.left);
                }
                if( curr.right != null )
                {
                    queue.offer(curr.right);
                }
            }
            if( currSum > max )
            {
                max = currSum;
                res = level;
            }
            level++;
        }
        return res;
    }
}
/*
BFS approach
Add values of all nodes in same level
Store it to check if level below it has greater value
Return the level with greatest sum
*/