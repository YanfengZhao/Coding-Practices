/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

// Solution 1 is more concise

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if(stack.isEmpty()){
                    return false;
            }
            else if(c == ')' && stack.peek() == '('){
                    stack.pop();
            }
            else if(c == ']' && stack.peek() == '['){
                    stack.pop();
            }
            else if(c == '}' && stack.peek() == '{'){
                    stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

// Solution 2
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> op = new Stack<Character>();
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                op.push(s.charAt(i));
            }
            else if(s.charAt(i)=='}'){
                if(op.isEmpty()){
                    return false;
                }
                if(op.peek()=='{'){
                    op.pop();
                }
                else return false;
            }
            else if(s.charAt(i)==']'){
                if(op.isEmpty()){
                    return false;
                }
                if(op.peek()=='['){
                    op.pop();
                }
                else return false;
            }
            else if(s.charAt(i)==')'){
                if(op.isEmpty()){
                    return false;
                }
                if(op.peek()=='('){
                    op.pop();
                }
                else return false;
            }
        }
        if(op.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
