/* Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Similar to inorder traversal.
// If have left child, push all on to stack in the constructor.
// hasNext() just need to check if stack is empty.
// in next(), if hasNext() == false, return 0.
// else, pop one off stack, check if the one has right child.
// if it does, add all it's left child nodes to stack.

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode curr;
    public BSTIterator(TreeNode root) {
        curr = root;
        while(curr!=null){
            stack.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        if(hasNext() == false){
            return 0;
        }
        TreeNode temp = stack.pop();
        if(temp.right!=null){
            TreeNode right = temp.right;
            while(right!=null){
                stack.push(right);
                right = right.left;
            }
        }
        return temp.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
