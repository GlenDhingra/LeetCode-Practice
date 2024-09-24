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
    public ListNode sortList(ListNode head) 
    {
        if( head == null || head.next == null )
        {
            return head;
        }
        ListNode mid = getMid( head );
        ListNode left = sortList( head );
        ListNode right = sortList( mid );
        return mergeSort( left , right );
    }
    public ListNode mergeSort( ListNode left , ListNode right )
    {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while( left != null && right != null )
        {
            if( left.val <= right.val )
            {
                pointer.next = left;
                left = left.next;
                pointer = pointer.next; 
            }
            else
            {
                pointer.next = right;
                right = right.next;
                pointer = pointer.next;
            }
        }
        if( left != null )
        {
            while( left != null )
            {
                pointer.next = left;
                left = left.next;
                pointer = pointer.next;
            }
        }
        if( right != null )
        {
            while( right != null )
            {
                pointer.next = right;
                right = right.next;
                pointer = pointer.next;
            }
        }
        return dummy.next;
        
    }
    public ListNode getMid( ListNode head )
    {
        ListNode fast = head;
        ListNode mid = head;
        ListNode midPrev = mid;
        while( fast!= null && fast.next != null )
        {
            fast = fast.next.next;
            midPrev = mid;
            mid = mid.next;
        }
        midPrev.next = null;
        return mid;
    }
}