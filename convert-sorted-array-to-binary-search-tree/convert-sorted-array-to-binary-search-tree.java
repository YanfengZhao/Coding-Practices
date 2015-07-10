/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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

// Use a recursive helper function with parameters, nums, start, and end.
// Start and end are indexes used to determine mid, which is where array split in half.

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
        	return null;
        }
        return helper(nums, 0, nums.length-1);
    }
	
	public TreeNode helper(int[] nums, int start, int end){
		if(start>end){
			return null;
		}
		
		// create a new TreeNode
		int mid = (start+end) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums,start,mid-1);
		node.right = helper(nums,mid+1,end);
		return node;
	}
}
