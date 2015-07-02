/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

// Use a stack for the ability of backtracing.
// Split the string into string array with delimeter "/".
// Traverse every element in pathArr:
// If stack is not empty and dir is "..", pop and element off the stack because ".." means to go back a directory.
// If dir is "." or the stack is empty while dir is "..", stay where you are.
// Otherwise push the dir on to stack.
// At this point, you have the most simplified absolute path, just append each item off stack in front of a StringBuilder

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        StringBuffer result = new StringBuffer();
        String[] pathArr = path.split("/");
        for(String dir:pathArr){
            if(!stack.isEmpty() && dir.equals("..")){
                stack.pop();
            }
            else if(dir.equals(".")||dir.length()==0||dir.equals("..")){
                continue;
            }
            else{
                stack.push(dir);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        while(!stack.isEmpty()){
            result.insert(0,stack.pop());
            result.insert(0,"/");
        }
        return result.toString();
    }
}
