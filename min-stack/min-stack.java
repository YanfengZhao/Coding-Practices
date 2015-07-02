/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

// the trick is to use 2 stacks. One keeps track of the stack, you only add to the other if the current number is smaller than or equal to the top of the min-stack
// when pop, pop off the original stack, if the item is equal to the top of the min-stack, then pop that off as well

class MinStack {
    Stack<Integer> s1 = new Stack<Integer>(); //stack
    Stack<Integer> s2 = new Stack<Integer>(); //minstack
    public void push(int x) {
        if(s2.isEmpty()||x<=s2.peek()){
            s1.push(x);
            s2.push(x);
        }
        else{
            s1.push(x);
        }
    }

    public void pop() {
        if(s1.peek().equals(s2.peek())){ // Need to use .equals because comparing Integer objects!!!
            s1.pop();
            s2.pop();
        }
        else{
            s1.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();    
    }
}

