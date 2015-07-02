/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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

// Use breadth first search, print level by level, but have a flag that toggles every level so you know whether to reverse or not

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> curLevel = new ArrayList<TreeNode>();
        
        if(root == null){
            return result;
        }
        
        curLevel.add(root);
        boolean reversed = false;
        
        while(curLevel.size() > 0){
            
            // create the next level
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode n:curLevel){
                if(n.left!=null){
                    nextLevel.add(n.left);
                }
                if(n.right!=null){
                    nextLevel.add(n.right);
                }
            }
            // add the current level to the list
            if(reversed == true){
                Collections.reverse(curLevel);
            }
            
            List<Integer> curLevelInt = new ArrayList<Integer>();
            for(TreeNode n:curLevel){
                curLevelInt.add(n.val);
            }
            result.add((ArrayList<Integer>)curLevelInt);
            
            // update current level and decide reverse for next level
            curLevel = nextLevel;
            reversed = !reversed;
        }
        return result;
    }
}
