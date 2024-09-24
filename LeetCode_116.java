/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution 
{
    public Node connect(Node root) 
    {
        if( root == null )
        {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while( !queue.isEmpty() )
        {
            int size = queue.size();
            for( int i = 0 ; i < size ; i++ )
            {
                Node curr = queue.poll();
                if( curr.left != null )
                {
                    queue.offer( curr.left );
                }
                if( curr.right != null )
                {
                    queue.offer( curr.right );
                }
                if( i != size - 1 )
                {
                    curr.next = queue.peek();
                }
            }
        }
        return root;
    }
}
/*
BFS approach
set the next pointer to the first element in the queue
skip the last element in the queue at every iteration as it's right will always be null

*/