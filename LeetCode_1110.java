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
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) 
    {
        List<Integer> find = new ArrayList<>();
        for( int i : to_delete ) find.add(i);
        if(!find.contains(root.val)) res.add(root);
        dfs(root,find);
        /*Queue<TreeNode> queue = new LinkedList<>();
        queue.offer( root );
        if(!find.contains(root.val))res.add(root);
        while( !queue.isEmpty() )
        {
            int size = queue.size();
            for( int i = 0 ; i < size ; i++ )
            {
                TreeNode curr = queue.poll();
                if( curr.left != null )
                {
                    queue.offer(curr.left);
                    if(find.contains(curr.left.val))
                    {
                        curr.left = null;
                    }
                }
                if( curr.right != null )
                {
                    queue.offer(curr.right);
                    if(find.contains(curr.right.val))
                    {
                        curr.right = null;
                    }
                }
                if(find.contains(curr.val))
                {
                    if(curr.left != null) res.add(curr.left);
                    if(curr.right != null) res.add(curr.right);
                    find.remove(new Integer(curr.val));
                }
            }
        }*/
        return res;
    }
    public void dfs(TreeNode root, List<Integer> find)
    {
        if(root == null) return;
        dfs(root.left,find);
        dfs(root.right,find);
        if(find.contains(root.val))
        {
            if(root.left != null && !find.contains(root.left.val)) res.add(root.left);
            if(root.right != null && !find.contains(root.right.val)) res.add(root.right);     
        }
        if(root.left != null && find.contains(root.left.val)) root.left = null;
        if(root.right != null && find.contains(root.right.val)) root.right = null;
        res.remove(new Integer(root.val));
    }
}
/*
DFS and BFS Approach[Both working]
*/