/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

// use a stack, add none operator strings to stack, once you see an operator, pop 2 off the stack and evaluate, then push result back on stack.

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0){
            return 0;
        }
        Stack<String> stack = new Stack<String>();
        for(String s : tokens){
            int a;
            int b;
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                b = Integer.parseInt(stack.pop());
                a = Integer.parseInt(stack.pop());
                if(s.equals("+")){
                    stack.push(Integer.toString(a+b));
                }
                else if(s.equals("-")){
                    stack.push(Integer.toString(a-b));
                }
                else if(s.equals("*")){
                    stack.push(Integer.toString(a*b));
                }
                else if(s.equals("/")){
                    stack.push(Integer.toString(a/b));
                }
            }
            else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
