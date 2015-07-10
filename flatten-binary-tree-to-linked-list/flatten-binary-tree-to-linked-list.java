/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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

// Recursion. If root is null, return.
// Remember to save the current node's left and right node.
// Set current node's left to null to flatten.
// Flatten left and right saved node.
// At this point assume current node has no left and right. Append left side to current node's right side.
// Lastly append right to the leaf of the right side.

public class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
        	return;
        }
        
        // create temps for the left and right node of current node
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        // set left node to null to flatten
        root.left = null;
        
        // flatten left and right node
        flatten(left);
        flatten(right);
        
        // append flattened left node to the right side.
        root.right = left;
        TreeNode cur = root;
        while(cur.right!=null){
        	cur = cur.right;
        }
        cur.right = right;
    }
}
