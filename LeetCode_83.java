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
    public ListNode deleteDuplicates(ListNode head) 
    {
        ListNode temp = head,pre=head;
        HashSet<Integer> set = new HashSet<>();
        if( head != null )
        {
            set.add(head.val);
        }
        else
        {
            return head;
        }
        
        while( temp.next != null )
        {
            pre=temp;
            temp=pre.next;
            if( set.contains(temp.val) )
            {
                pre.next = temp.next;
                temp = pre;
            }
            else
            {
                set.add(temp.val);
            }
        }
        return head;
    }
}