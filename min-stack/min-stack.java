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

