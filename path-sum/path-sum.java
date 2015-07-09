/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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

// Optimized
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return sum == root.val;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

// dfs. Could be improved:
// Only need to pass 2 parameters instead of 3 by subtract from sum.
// If base case == 0, then return true;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return dfsHelper(root,sum,0);
    }
    
    public boolean dfsHelper(TreeNode node, int sum, int currSum){
        if(node.left == null && node.right == null){
            return currSum+node.val == sum;
        }
        
        if(node.left!=null && node.right != null){
            return dfsHelper(node.left,sum,currSum+node.val) || dfsHelper(node.right,sum,currSum+node.val);
        }
        else if(node.left!=null){
            return dfsHelper(node.left,sum,currSum+node.val);
        }
        else{
            return dfsHelper(node.right,sum,currSum+node.val);
        }
    }
}
