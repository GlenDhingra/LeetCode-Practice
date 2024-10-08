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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList();
        if( root == null )
            return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        List<Integer> list;
        while( !queue.isEmpty() )
        {
            int size = queue.size();
            list = new ArrayList();
            for( int i = 0 ; i < size ; i++ )
            {
                TreeNode curr = queue.poll();
                if( curr.left != null )
                    queue.offer(curr.left);
                if( curr.right != null )
                    queue.offer( curr.right );
                list.add(curr.val);
            }
            res.add(list);
        }
        return res;
    }
}