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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while( !queue.isEmpty() )
        {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for( int i = 0 ;  i < size ; i++ )
            {
                TreeNode curr = queue.poll();
                max = Math.max( max , curr.val );
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            res.add(max);
        }
        return res;
    }
}
/*
Breadth First Search Approach
Find the max element at each level and add it to the list
*/