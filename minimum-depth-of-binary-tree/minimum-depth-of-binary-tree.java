/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// bfs, if any node at current level has no left or right child, return counter

public class Solution {
    public int minDepth(TreeNode root) {
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
                if(n.left == null && n.right == null){
                    return counter;
                }
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
