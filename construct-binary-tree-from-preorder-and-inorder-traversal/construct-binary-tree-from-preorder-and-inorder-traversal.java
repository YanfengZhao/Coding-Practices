/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
 
// Use recursion.
// The first element in preorder must be root.
// Go to inorder list, find the root element. Everything left of it must be left subtree, right of it is right subtree.
// Look back in preorder, 
// find number of elements equal to the number of left subtree, call recursion method, the rest is right subtree, call recursion

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
	
	public TreeNode helper(int[] preorder, int[] inorder,int startPO, int endPO, int startIO, int endIO){
		if(startPO>endPO){
			return null;
		}
		TreeNode node = new TreeNode(preorder[startPO]);
		
		// find where this node appear in inorder list
		int index = 0;
		for(int i = startIO; i<= endIO; i++){
            if(preorder[startPO] == inorder[i]){
                index = i;
                break;
            }
        }
		
		// find how many are left of the node and how many are right of the node
		int numLeft = index - startIO;
		int numRight = endIO - index;
		
        node.left = helper(preorder,inorder,startPO+1,startPO+numLeft,startIO,index-1);
        node.right = helper(preorder,inorder,startPO+numLeft+1,startPO+numLeft+numRight,index+1, index+numRight);
        return node;
	}
}
