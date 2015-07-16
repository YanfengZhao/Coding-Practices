/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
 
// bfs level by level, add the last element of each level to the list

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        List<TreeNode> currLevel = new ArrayList<TreeNode>();
        currLevel.add(root);
        while(currLevel.size() != 0){
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(int i = 0; i < currLevel.size(); i++){
                if(currLevel.get(i).left != null) nextLevel.add(currLevel.get(i).left);
                if(currLevel.get(i).right != null) nextLevel.add(currLevel.get(i).right);
                if(i == currLevel.size()-1){
                    result.add(currLevel.get(i).val);
                }
            }
            currLevel = nextLevel;
        }
        return result;
    }
}
