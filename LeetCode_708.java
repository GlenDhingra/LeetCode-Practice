/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if( head == null ){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node curr = head;
        while( curr.next != head ){
            if( curr.val <= insertVal && insertVal <= curr.next.val ){
                break;
            }
            if( curr.val > curr.next.val ){
                if( insertVal >= curr.val || insertVal <= curr.next.val ){
                    break;
                }
            }
            curr = curr.next;
        }
        Node newNode = new Node(insertVal);
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }
}