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

// Solution 0, best solution, beats 95.85% submissions.

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        helper(root, results, new ArrayList<Integer>(), sum);
        return results;
    }
    
    public void helper(TreeNode root, List<List<Integer>> results, List<Integer> cur, int sum){
        if (root == null){
            return;
        }
        
        cur.add(root.val);
        
        if (root.left == null && root.right == null && sum == root.val){
            results.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        
        helper(root.left, results, cur, sum - root.val);
        helper(root.right, results, cur, sum - root.val);
        cur.remove(cur.size() - 1);
    }
}

// Solution 1 does not use global result, it is passed in.
// You also call the helper method on null nodes, but it will be taken care of first thing in the method.
// For every node you add into currPath, subtract the value from sum.
// Base case is when you hit the leaf node.

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        helper(root,sum,result,new ArrayList<Integer>());
        return result;
    }
    
    public void helper(TreeNode node, int sum, List<List<Integer>> result, List<Integer> currPath){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            if(sum == node.val){
                currPath.add(node.val);
                result.add(new ArrayList<Integer>(currPath));
                currPath.remove(currPath.size()-1);
            }
            return;
        }
        currPath.add(node.val);
        helper(node.left, sum - node.val, result, currPath);
        helper(node.right, sum - node.val, result, currPath);
        currPath.remove(currPath.size()-1);
    }
}

// Solution 2, not as good.
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
