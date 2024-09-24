/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode middleNode(ListNode head) 
    {
        ListNode fast = head;
        ListNode slow = head;
        
        while( fast != null && fast.next != null )
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
/*
Initialize a fast pointer and slow pointer
The fast pointer will always jump two nodes
The slow pointer will always jump a single node
When the fast pointer reaches the end of the list the slow pointer will be at the mid of the linked list
*/