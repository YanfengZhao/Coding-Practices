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

// Solution 2. Recursion

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root,1);
    }
    
    public int helper(TreeNode root, int level){

        if(root.left == null && root.right == null){
            return level;
        }
        else if(root.left == null){
            return helper(root.right,level+1);
        }
        else if(root.right == null){
            return helper(root.left,level+1);
        }
        else{
            return Math.min(helper(root.left,level+1),helper(root.right,level+1));
        }
    }
}
