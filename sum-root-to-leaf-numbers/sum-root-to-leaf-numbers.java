/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
 
// use dfs and recursion, O(n).
// If left and right are null, then you are at the leaf node, return a number.
// otherwise keep calculating.

public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root,"");
    }
    
    public int dfs(TreeNode node, String num){
        if(node.left == null && node.right == null){
            return Integer.parseInt(num+node.val);
        }
        if(node.left!=null && node.right!=null){
            return dfs(node.left, num+node.val)+dfs(node.right, num+node.val);
        }
        else if(node.left!=null){
            return dfs(node.left, num+node.val);
        }
        else{
            return dfs(node.right, num+node.val);
        }
    }
}

// Solution 2. Recursion, O(n), use a global sum.

public class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root,"");
        return sum;
    }
    
    public void helper(TreeNode root, String num){
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(num+root.val);
            return;
        }
        if(root.left!=null){
            helper(root.left, num+root.val);
        }
        if(root.right!=null){
            helper(root.right,num+root.val);
        }
    }
}
