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
