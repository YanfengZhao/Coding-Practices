/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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

// Solution 1 in order to calculate the height of a node, it first calculate the height of its children.
// Solution 2 calculate every node's height multiple times, not very efficient but does not use global variable.
// Solution 3 uses bfs

public class Solution {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root){
        helper(root);
        return isBalanced;
    }
    
    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = helper(node.left);
        int rightHeight = helper(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1){
            isBalanced = false;
        }
        int currentHeight = Math.max(leftHeight,rightHeight)+1;
        return currentHeight;
    }
    
    public boolean isBalancedS2(TreeNode root) {
        if(root == null){
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1){
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }
    
    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1+Math.max(getHeight(node.left),getHeight(node.right));
    }
}

// bfs
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int counter = 0; // check unbalance
        boolean nullOnNextLevel = false;
        ArrayList<TreeNode> currLevel = new ArrayList<TreeNode>();
        currLevel.add(root);
        while(true){
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode node:currLevel){
                if(node.left != null){
                    nextLevel.add(node.left);
                }
                if(node.right != null){
                    nextLevel.add(node.right);
                }
                if(node.left==null || node.right==null) nullOnNextLevel = true;
            }
            
            if (nullOnNextLevel==true) counter++;
            if (counter == 3) return false;
            if (nextLevel.isEmpty()) return true;
            currLevel = nextLevel;
        }
    }
}
