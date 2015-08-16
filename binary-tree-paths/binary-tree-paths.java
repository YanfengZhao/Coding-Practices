/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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

// Recursion. Base case if both children are null, then must be leave node, add node and and path to result.
// If left is not null, add node and "->" and call recursive method on left node.
// If right is not null, add node and "->" and call recursive method on right node.

public class Solution {
    List<String> result = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return result;
        }
        helper(root,"");
        return result;
    }
    
    public void helper(TreeNode node, String curPath){
        if(node.left == null && node.right == null){
            // this is a leave node, add to result
            result.add(curPath+""+node.val);
            return;
        }
        
        // if not a leave node, add to curPath
        if(node.left != null){
            helper(node.left, curPath+node.val+"->");
        }
        if(node.right != null){
            helper(node.right, curPath+node.val+"->");
        }
    }
}
