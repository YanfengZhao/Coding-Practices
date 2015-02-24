/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return result;
        inorderHelper(root);
        return result;
    }
    public void inorderHelper(TreeNode root){
        if(root.left!=null) inorderHelper(root.left);
        result.add(root.val);
        if(root.right!=null) inorderHelper(root.right);
    }
}
