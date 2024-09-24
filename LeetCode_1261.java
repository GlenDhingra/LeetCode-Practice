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
class FindElements 
{
    HashSet<Integer> list = new HashSet<>();    
    public FindElements(TreeNode root) 
    {
        if( root != null )
        {
            root.val = 0;
            list.add(0);
            setValueOf(root);
        }
    }
    public boolean find(int target) 
    {
        return list.contains(target);
    }
    public void setValueOf( TreeNode root )
    {
        if( root == null )
        {
            return;
        }
        if( root.left != null )
        {
            root.left.val = (2 * root.val) + 1;
            list.add(root.left.val);
            
        }
        if( root.right != null )
        {
            root.right.val = (2 * root.val) + 2;
            list.add(root.right.val);
            
        }
        setValueOf(root.left);
        setValueOf(root.right);
        return;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */