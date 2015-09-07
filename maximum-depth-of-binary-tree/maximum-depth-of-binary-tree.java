/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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

// recursive solution

public class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root,0);
    }
    
    public int helper(TreeNode root, int level){
        if(root == null){
            return level;
        }
        return Math.max(helper(root.left,level+1),helper(root.right,level+1));
    }
}

// bfs solution

public class Solution {
    public int maxDepth(TreeNode root) {
        int counter = 0;
        if(root == null){
            return counter;
        }
        LinkedList<TreeNode> currLevel = new LinkedList<TreeNode>();
        currLevel.add(root);
        while(!currLevel.isEmpty()){
            counter++;
            LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
            for(TreeNode n: currLevel){
                if(n.left!=null){
                    nextLevel.add(n.left);
                }
                if(n.right!=null){
                    nextLevel.add(n.right);
                }
            }
            currLevel = nextLevel;
        }
        return counter;
    }
}
