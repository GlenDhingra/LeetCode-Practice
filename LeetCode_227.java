class Solution {
    public int calculate(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        char action = '+';
        while( i < arr.length ){
            if( arr[i] == ' ' ){
                i++;
                continue;
            }
            if( Character.isDigit(arr[i]) ){
                StringBuilder current = new StringBuilder();
                while( i < arr.length && Character.isDigit(arr[i]) ){
                    current.append(arr[i]);
                    i++;
                }    
                i--;
                int num = Integer.parseInt(current.toString());
                if( action == '*' ){
                    num *= stack.pop();
                }
                else if( action == '-' ){
                    num *= -1;
                }
                else if( action == '/' ){
                    num = stack.pop() / num;
                }
                stack.push(num);
            }
            else{
                action = arr[i];
            }
            i++;
        }
        int res = 0;
        while( !stack.isEmpty() ){
            res += stack.pop();
        }
        return res;
    }
}