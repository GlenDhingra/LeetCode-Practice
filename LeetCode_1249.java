class Solution {
    public String minRemoveToMakeValid(String s) 
    {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        
        for( int i = 0 ; i < s.length() ; i++ )
        {
            if( s.charAt(i) == '(' || s.charAt(i) == ')' )
            {
                if( s.charAt(i) == '(' )
                {
                    stack.push(index); 
                }
                else if( s.charAt(i) == ')' )
                {
                    if( stack.isEmpty() )
                    {
                        sb.deleteCharAt(index);           
                        continue;   //Will not increment index
                                    //index is used to point at '(' which has no closing ')'
                    }
                    stack.pop();
                }    
            }
            index++;
            
        }
        while( !stack.isEmpty() )
        {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
}