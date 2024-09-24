class Solution {
    public int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for( int i = 0 ; i < s.length() ; i++ )
        {
            if(!stack.isEmpty() && s.charAt(i) != stack.peek()) stack.pop();
            else stack.push(s.charAt(i));
            if(stack.isEmpty()) count++;
        }
        return count;
    }
}
/*
Add the first encountered element in stack when stack is empty
When a new element is encountered then remove an element from stack
increment count when stack is empty
*/