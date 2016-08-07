/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Use a stack, initialize it by pushing the left node on until the smallest number is added.
// For getting the next, save the number on top of the stack, which will be the result,
// See if that node has a right child, and then push that node and every number to the left of it onto the stack.

public class BSTIterator {
    public Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null){
            stack.push(root);
            while(root.left != null){
                stack.push(root.left);
                root = root.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.isEmpty()){
            return false;
        }
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        int result = temp.val;
        if (temp.right != null){
            temp = temp.right;
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
        }
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
