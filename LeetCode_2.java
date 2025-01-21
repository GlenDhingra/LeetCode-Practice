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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode head = new ListNode(-1);
        ListNode pointer = head;
        int carry = 0;
        while( pointer1 != null && pointer2 != null ){
            int sum = pointer1.val + pointer2.val + carry;
            carry = sum / 10;
            sum %= 10;
            ListNode newNode = new ListNode(sum);
            pointer.next = newNode;
            pointer = pointer.next;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        while( pointer1 != null ){
            int sum = pointer1.val + carry;
            carry = sum / 10;
            sum %= 10;
            ListNode newNode = new ListNode(sum);
            pointer.next = newNode;
            pointer = pointer.next;
            pointer1 = pointer1.next;
        }
        while( pointer2 != null ){
            int sum = pointer2.val + carry;
            carry = sum / 10;
            sum %= 10;
            ListNode newNode = new ListNode(sum);
            pointer.next = newNode;
            pointer = pointer.next;
            pointer2 = pointer2.next;
        }
        if( carry > 0 ){
            ListNode newNode = new ListNode(carry);
            pointer.next = newNode;
            pointer = pointer.next;
        }
        return head.next;
    }
}
/*
    1   1   1   1

9   9   9   9   9   9   9
9   9   9   9

8   9   9   9

*/