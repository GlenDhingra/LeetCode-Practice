class Solution {
    public String removeDuplicates(String s) 
    {
        if( s.length() == 1 || s.length() == 0 )
        {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        
        for( int i = 1 ; i < s.length() ; i++ )
        {
            
            if( !stack.isEmpty() && s.charAt(i) == stack.peek() )
            {
                stack.pop();
            }
            else
            {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder("");
        for( int i = 0 ; i < stack.size() ; i++ )
        {
            sb.append(stack.get(i));
        }
        return sb.toString();
        
        
    }
}