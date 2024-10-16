class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for( int i = 0 ; i < s.length() ; i++ ){
            if( s.charAt(i) == '(' ){
                stack.push(i);
            }
            else if( s.charAt(i) == ')' ){
                if( !stack.isEmpty() && s.charAt(stack.peek()) == '(' ){
                    stack.pop();
                }
                else{
                    stack.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder(s);
        while( !stack.isEmpty() ){
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
}