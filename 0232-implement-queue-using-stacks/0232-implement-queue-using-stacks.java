import java.util.Stack;

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Push element to the back of the queue
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from the front of the queue and returns it
    public int pop() {
        peek(); // Move elements if needed
        return s2.pop();
    }

    // Get the front element
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    // Returns whether the queue is empty
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
