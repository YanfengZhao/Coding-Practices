/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left,root.right);
    }
    
    public boolean recur(TreeNode leftNode, TreeNode rightNode){
        if (leftNode == null || rightNode == null)
            return leftNode == rightNode;
        if (leftNode.val != rightNode.val)
            return false;
        return recur(leftNode.left,rightNode.right) && recur(leftNode.right,rightNode.left);
    
    }
}
