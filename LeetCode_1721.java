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
    public ListNode swapNodes(ListNode head, int k) 
    {
        ListNode curr = head;
        ListNode pointer1 = head;
        ListNode pointer2= head;
        int count = 1;
        
        while( curr != null )
        {
            if( count < k )
            {
                pointer1 = pointer1.next;
            }
            if( count > k )
            {
                pointer2 = pointer2.next;
            }
            curr = curr.next;
            count++;
        }
        
        int temp = pointer1.val;
        pointer1.val = pointer2.val;
        pointer2.val = temp;
        
        return head;
    }
}
/*

Created a pointer which traverses till the end of the linkedlist
Created pointer1 which will stop after reaching kth element
Created pointer2 which will have a delayed start by kth number
Swap values of pointer1 and pointer2

Time Complexity O(n)
*/