/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
 
// Recursion. Inorder traversal. O(k).
// Have a global count count up to k. Once count equals to k, save the val in node in result.

public class Solution {
    int result = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return result;
    }
    
    public void helper(TreeNode node,int k){
        if(node == null){
            return;
        }
        helper(node.left,k);
        count++;
        if(count == k){
            result = node.val;
            return;
        }
        helper(node.right,k);
    }
}
