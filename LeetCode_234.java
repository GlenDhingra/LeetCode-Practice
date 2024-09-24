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
    public boolean isPalindrome(ListNode head) 
    {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        
        while( fast != null && fast.next != null )
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(slow.next == null)
        {
            return head.val == slow.val;
        }
        if(fast != null) slow = slow.next;
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while( slow != null )
        {
            sb1.append(head.val);
            sb2.append(slow.val);
            head = head.next;
            slow = slow.next;
        }
        return sb1.compareTo(sb2.reverse()) == 0;
    }
}