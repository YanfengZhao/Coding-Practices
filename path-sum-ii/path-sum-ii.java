/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
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
 
// Create a DFS recursive helper method, pass in node, sum (keep subtracting from sum),
// and the ArrayList that contains the current path.
// If at the leaf and the sum == 0, then add the path to result.

public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if(root == null){
            return result;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        dfsHelper(root,sum,temp);
        return result;
    }
    
    public void dfsHelper(TreeNode node, int sum, ArrayList<Integer> temp){
        if(node.left == null && node.right == null && sum-node.val == 0){
        	temp.add(node.val);
            result.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        if(node.left!=null){
        	temp.add(node.val);
        	dfsHelper(node.left,sum-node.val,temp);
        	temp.remove(temp.size()-1);
        }
        if(node.right!=null){
        	temp.add(node.val);
        	dfsHelper(node.right,sum-node.val,temp);
        	temp.remove(temp.size()-1);
        }
    }
}
