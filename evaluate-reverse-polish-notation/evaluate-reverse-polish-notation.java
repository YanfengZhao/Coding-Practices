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
