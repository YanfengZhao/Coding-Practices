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
