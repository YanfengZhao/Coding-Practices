/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
 
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        List<TreeNode> currLevel = new ArrayList<TreeNode>();
        currLevel.add(root);
        while(currLevel.size() != 0){
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            List<Integer> currInts = new ArrayList<Integer>();
            for(TreeNode n: currLevel){
                currInts.add(n.val);
                if(n.left!=null) nextLevel.add(n.left);
                if(n.right!=null) nextLevel.add(n.right);
            }
            result.add(0,currInts);
            currLevel = nextLevel;
        }
        return result;
    }
}
