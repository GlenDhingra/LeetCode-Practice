class MinStack {
    Stack<Node> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = Integer.MAX_VALUE;
        if( stack.isEmpty() ){
            min = val;
        }
        else{
            min = Math.min(val, stack.peek().getMin());
        }
        Node node = new Node(val, min);
        stack.push(node);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getVal();
    }
    
    public int getMin() {
        return stack.peek().getMin();
    }
}
class Node{
    int val,min;
    public Node(int val, int min){
        this.val = val;
        this.min = min;
    }
    public int getVal(){
        return val;
    }
    public int getMin(){
        return min;
    }
    public void setVal(int val){
        this.val = val;
    }
    public void setMin(int min){
        this.min = min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */