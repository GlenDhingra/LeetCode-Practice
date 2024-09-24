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
    public int[] nextLargerNodes(ListNode head) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode pointer = head;
        
        while( pointer != null )
        {
            list.add(pointer.val);
            pointer = pointer.next;
        }
        
        int[] arr = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for( int i = 0 ; i < list.size() ; i++ )
        {
            while( !stack.isEmpty() && list.get(stack.peek()) < list.get(i) )
            {
                arr[stack.pop()] = list.get(i);   
            }
            stack.push(i);
        }
        return arr;
    }
}