/*
Given inorder and postorder traversal of a tree, construct the binary tree.

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
 
// see construct-binary-tree-from-inorder-and-postorder-traversal

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }
        return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
	
	public TreeNode helper(int[] inorder, int[] postorder,int startIO, int endIO, int startPO, int endPO){
		if(startPO>endPO){
			return null;
		}
		TreeNode node = new TreeNode(postorder[endPO]);
		
		// find where this node appear in inorder list
		int index = 0;
        for(int i = startIO; i<= endIO; i++){
            if(postorder[endPO] == inorder[i]){
                index = i;
                break;
            }
        }
		
		// find how many are left of the node and how many are right of the node
		int numLeft = index - startIO;
		int numRight = endIO - index;
		
        node.left = helper(inorder,postorder,startIO,index-1,startPO,startPO+numLeft-1);
        node.right = helper(inorder,postorder,index+1, index+numRight, startPO+numLeft,startPO+numLeft+numRight-1);
        return node;
	}
}
