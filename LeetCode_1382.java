class Solution 
{
    ArrayList<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) 
    {
        inorder(root);
        return generateBinaryTree( 0 , list.size() - 1 );
    }
    public void inorder(TreeNode root)
    {
        if( root == null )
        {
            return;
        }
        inorder( root.left );
        list.add(root.val);
        inorder( root.right);
    }
    public TreeNode generateBinaryTree( int start , int end )
    {
        if( start > end )
        {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode( list.get(mid) );
        root.left = generateBinaryTree( start , mid - 1 );
        root.right = generateBinaryTree( mid + 1 , end );
        return root;
    }
}
/*
Adding the values of the tree in an arraylist in Inorder manner[which resulls in a sorted arraylist]
Applying Divide and Conquer approach by dividing array into two equal parts and setting the mid element as root at each level
*/