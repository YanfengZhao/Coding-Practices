/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/

// Solution 1
// Use 2 queues. Maintain queue 2 as the stack.
// Everytime you add an element, move all element to q1, add the new element to q2,
// then move everything in q1 back to q2.

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    public MyStack(){
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        // initially move everything into q1 as preprocess
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        
        // offer x to q2 once q2 is empty
        q2.offer(x);
        
        // move every element from q1 to q2, now q2 acts like a stack
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q2.poll();
    }

    // Get the top element.
    public int top() {
        return q2.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q2.isEmpty();
    }
}

// Solution 2

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack (){
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    // Push element x onto stack.
    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.poll();
    }

    // Get the top element.
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
