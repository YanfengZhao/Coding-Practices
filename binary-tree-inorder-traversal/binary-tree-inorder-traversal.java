/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        if(root == null){
            return result;
        }
        stack.push(root);
        
        while(!stack.empty()){
            // if already checked this node's left, skip
            if(!visited.contains(stack.peek())){
                // keep checking if this node has left node, and push on stack
                while(stack.peek().left!=null){
                    visited.add(stack.peek());
                    visited.add(stack.peek().left);
                    stack.push(stack.peek().left);
                }
            }
            // pop the current off the stack and add to result
            TreeNode curr = stack.pop();
            result.add(curr.val);
            // if right node exist, push on stack
            if(curr.right!=null){
                stack.push(curr.right);
            }
        }
        return result;
    }
}
