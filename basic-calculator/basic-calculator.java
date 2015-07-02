/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/

// the key is to first convert from infix to postfix, then evaluate

public class Solution {
    public int calculate(String s) {
        // preprosess adding the string to an array
        ArrayList<String> slist = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)==' '){
                // if previous is num, add the sb to slist and clear sb
                if(i!=0 && s.charAt(i-1) <= '9' && s.charAt(i-1) >= '0'){
                    slist.add(sb.toString());
                    sb.setLength(0);
                }
                continue;
            }
            else if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='(' ||s.charAt(i)==')'){
                // if previous is num, add the sb to slist and clear sb
                if(i!=0 && s.charAt(i-1) <= '9' && s.charAt(i-1) >= '0'){
                    slist.add(sb.toString());
                    sb.setLength(0);
                }
                slist.add(s.charAt(i)+"");
            }
            else if(s.charAt(i) <= '9' && s.charAt(i) >= '0'){
                sb.append(s.charAt(i));
            } 
        }
        if(sb.length()>0){
            slist.add(sb.toString());
            sb.setLength(0);
        }
        
        // update slist from infix to post fix
        slist = infixToPostfix(slist);
        return evaluateResult(slist);
    }
    
    public ArrayList<String> infixToPostfix(ArrayList<String> infix){
        ArrayList<String> postfix = new ArrayList<String>();
        Stack<String> opStack = new Stack<String>();
        for(int i = 0; i < infix.size(); i++){
            if(infix.get(i).equals("+") || infix.get(i).equals("-")){
                if(!opStack.empty() && !opStack.peek().equals("(")){
                    postfix.add(opStack.pop());
                }
                opStack.push(infix.get(i));
            }
            else if(infix.get(i).equals("(")){
                opStack.push(infix.get(i));
            }
            else if(infix.get(i).equals(")")){
                while(!opStack.peek().equals("(")){
                    postfix.add(opStack.pop());
                }
                opStack.pop();
            }
            else{
                postfix.add(infix.get(i));
            }
        }
        while(!opStack.empty()){
        	postfix.add(opStack.pop());
        }
        return postfix;
    }
    
    public int evaluateResult(ArrayList<String> postfix){
        if(postfix.size()==0){
            return 0;
        }
        Stack<String> stack = new Stack<String>();
        for(String s : postfix){
            int a;
            int b;
            if(s.equals("+") || s.equals("-")){
                b = Integer.parseInt(stack.pop());
                a = Integer.parseInt(stack.pop());
                if(s.equals("+")){
                    stack.push(Integer.toString(a+b));
                }
                else if(s.equals("-")){
                    stack.push(Integer.toString(a-b));
                }
            }
            else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
