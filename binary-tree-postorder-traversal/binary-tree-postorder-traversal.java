/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
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

// Recursion
public class Solution {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }
}

// Iterative solution. Similar to preorder traversal.
// The key is to use a LinkedList so you can use the method addFirst().
// First add the current to the list,
// second push left on stack, and then right on stack.
// Every time you are adding the current node to the return list, you add in front fo the list.

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur= stack.pop();
            result.addFirst(cur.val); // this is the key
            if(cur.left!=null){
                stack.push(cur.left);
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
            
        }
        return result;
    }
}
