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
class Solution {
    public ListNode swapPairs(ListNode head) 
    {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;
        
        while( current.next!=null && current.next.next!=null )
        {
            ListNode prev = current.next;
            ListNode post = current.next.next;
            prev.next = post.next;
            current.next = post;
            post.next=prev;
            current = prev;
        }
        return temp.next;
    }
}