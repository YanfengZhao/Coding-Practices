/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
 
// Store all the node values into an ArrayList.
// Use recursion like in converting sorted array to binary search tree, pass left index and right index.
// Mid is always the parent.

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }
        return helper(arr,0,arr.size()-1);
    }
    
    public TreeNode helper(ArrayList<Integer> arr, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = helper(arr,start,mid-1);
        node.right = helper(arr,mid+1,end);
        return node;
    }
}
