/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Inorder traversal without recursion is the medium difficulty one after the easy preorder traversal.
// Again uses a stack. A hashset that stores the left nodes that has already been seen and added to stack before.
// Start at a node, add all its left node to the stack if they are not in the hashset.
// Pop the first on the stack and add to result, if the right child exist, add to stack, and treat that node as root and repeat this process.
// If no right node, check if stack is empty, back to the outer loop.

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
