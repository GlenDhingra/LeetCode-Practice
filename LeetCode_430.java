/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) 
    {
        Node curr = head;
        while( curr != null )
        {
            if( curr.child == null )
            {
                curr = curr.next;
            }
            else
            {
                Node currNext = curr.next;
                Node last = getLast( curr.child );
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                last.next = currNext;
                if( currNext != null )
                {
                    currNext.prev = last;
                }
                
                curr = curr.next;
            }
        }
        return head;
    }
    public Node getLast( Node head )
    {
        while( head.next != null )
        {
            head = head.next;
        }
        return head;
    }
}
/*
Tough to explain :) 
*/