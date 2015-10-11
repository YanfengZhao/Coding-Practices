/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
 
// Recursion. Have a global max keep track of the max at all times.
// For each node, if the node is null, return 0.
// Find the current max including this node:
// (node itself, node and its left side, node and its right side), this value will be returned later
// Update the global max:
// (prev max, node itself, node with left, node with right, node with left and right)

public class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftMax = helper(root.left);
        int rightMax = helper(root.right);
        
        // calculate the max of current:
        // (the node by itself, the root and its left side, the root and its right side)
        int current = Math.max(root.val,Math.max(leftMax+root.val,rightMax+root.val));
        
        // update the overall max with this node included
        max = Math.max(max, Math.max(leftMax+rightMax+root.val,current));
        
        
        return current;
    }
}
