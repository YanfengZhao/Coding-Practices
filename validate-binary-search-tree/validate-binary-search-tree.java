/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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

// Just an inorder traversal. Have an global make sure current is bigger than previous.
// This solution doesn't need helper method and is cleaner.

public class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (prev != null && root.val <= prev.val) {
            return false;
        } else {
            prev = root;
        }
        boolean right = isValidBST(root.right);
        return left && right;
    }
}

// Uses in-order traversal.
// keep a global TreeNode prev to ensure later nodes are greater than prev nodes.
// check left node see if true, then check current node, lastly check the right node.

public class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    public boolean helper(TreeNode node){
        if(node == null){
            return true;
        }
        
        if(!helper(node.left)){
            return false;
        }
        if(prev!=null && prev.val >= node.val){
            return false;
        }
        prev = node;
        return helper(node.right);
    }
}
