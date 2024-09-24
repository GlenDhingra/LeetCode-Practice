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
    public ListNode deleteDuplicates(ListNode head) 
    {
        if( head == null || head.next == null )
        {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        dummy.next = head;
        ListNode pre = head;
        ListNode post = head.next;
        while( post != null )
        {
            if( pre.val == post.val )
            {
                while( post != null && pre.val == post.val )
                {
                    post = post.next;
                }
                dummy.next = post;
                pre = post;
                if(post != null) post = post.next;
            }
            else
            {
                dummy.next = pre;
                dummy = dummy.next;
                pre = pre.next;
                post = post.next;
            }
        }
        return res.next;
    }
}