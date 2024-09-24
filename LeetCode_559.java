/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution 
{
    public int maxDepth(Node root) 
    {
        return dfs(root);       
    }
    public int dfs(Node root)
    {
        if(root == null) return 0;
        int max = 0;
        if(!root.children.isEmpty())
        {
            for( int i = 0 ; i < root.children.size() ; i++ )
            {
                max = Math.max(max,dfs(root.children.get(i)));
            }
        }
        return max + 1;
    }
}