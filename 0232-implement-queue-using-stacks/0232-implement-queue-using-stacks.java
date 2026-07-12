class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if(!stack2.isEmpty()){
            int val = stack2.pop();
            return val;
        }
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        
        int value = stack2.pop();
        return value;
    }
    
    public int peek() {
        if(!stack2.isEmpty()){
            int val = stack2.peek();
            return val;
        }
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        
        int value = stack2.peek();
        return value;
        
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */