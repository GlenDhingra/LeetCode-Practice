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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) 
    {
        List<Integer> list = new ArrayList<>();
        /*  Use BFS or DFS
        bfs(root1,list);
        bfs(root2,list);
        */
        dfs(root1,list);
        dfs(root2,list);
        Collections.sort(list);
        return list;
        
    }
    public void bfs( TreeNode root, List<Integer> list )
    {
        if( root == null )
        {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while( !queue.isEmpty() )
        {
            int size = queue.size();
            for( int i = 0 ; i < size ; i++ )
            {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if( curr.left != null )
                {
                    queue.offer(curr.left);
                }
                if( curr.right != null )
                {
                    queue.offer(curr.right);
                }
            }
        }
    }
    public void dfs( TreeNode root , List<Integer> list )
    {
        if( root == null )
        {
            return;
        }
        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
    }
}