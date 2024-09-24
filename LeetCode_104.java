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
    public int maxDepth(TreeNode root) 
    {
        return dfs(root);
    }
    public int bfs(TreeNode root)
    {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size ; i++)
            {
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            level++;
        }
        return level;
    }
    public int dfs(TreeNode root)
    {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left,right)+1;
    }
}