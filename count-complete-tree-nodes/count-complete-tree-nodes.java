/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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

// Can be done in log(n)log(n).
// Facts: number of nodes in a perfect tree is 2^h-1, number of leaves is 2^(h-1)
// Need to run getHeight on both right and left nodes. 
// Always check left, or always check right.
// In the solution below, the height is defined by right child
// If left height != right height, left tree is perfect, calculate number of leaves in the left tree. Call helper on right.
// If left height == right height, right bottom is all empty, call helper on left.
// In the helper method, parameters include: node, level, number of leaves.
// Base case when hit a node with either left node as null or right node is null, return all node
// up to current level plus number of leaves.

public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        return helper(root, 1, 0);
    }
    
    public int helper(TreeNode node, int level, int leaves){
        if(node.left == null || node.right == null){
            return (int)Math.pow(2,level) - 1 + leaves + (node.left == null? 0:1);
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        
        if(left != right){
            leaves += Math.pow(2 , left - 1);
            return helper(node.right, level+1, leaves);
        }
        else{
            return helper(node.left, level+1, leaves);
        }
        
    }
    
    public int getHeight(TreeNode node){
        int counter = 0;
        while(node!=null){
            counter++;
            node = node.right;
        }
        return counter;
    }
}
