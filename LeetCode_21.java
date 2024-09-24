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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        if( l1 == null ) return l2;
        if( l2 == null ) return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode temp = dummy;
        
        while( pointer1 != null && pointer2 != null )
        {
            if( pointer1.val < pointer2.val )
            {
                temp.next = pointer1;
                pointer1 = pointer1.next;
                temp = temp.next;
            }
            else
            {
                temp.next = pointer2;
                pointer2 = pointer2.next;
                temp = temp.next;
            }
        }
        while( pointer1 != null )
        {
            temp.next = pointer1;
            pointer1 = pointer1.next;
            temp = temp.next;
        }
        while( pointer2 != null )
        {
            temp.next = pointer2;
            pointer2 = pointer2.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}