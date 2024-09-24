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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        int count = 0;
        while( fast != null )
        {
            fast = fast.next;
            if( count >= n )
            {
                prev = slow;
                slow = slow.next;
            }
            count++;
        }
        if( slow == head )
        {
            return slow.next;
        }
        prev.next = slow.next;
        return head;
    }
}
/*
Initialize two pointers fast and slow
Fast will traverse till the end of list
Slow will start traversal after n steps of fast
Link the previous of slow to the next of slow
Important Case : if slow is same as head, return head.next

*/