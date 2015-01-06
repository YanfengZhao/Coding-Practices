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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int counter = 0; // check unbalance
        boolean nullOnNextLevel = false;
        ArrayList<TreeNode> currLevel = new ArrayList<TreeNode>();
        currLevel.add(root);
        while(true){
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode node:currLevel){
                if(node.left != null){
                    nextLevel.add(node.left);
                }
                if(node.right != null){
                    nextLevel.add(node.right);
                }
                if(node.left==null || node.right==null) nullOnNextLevel = true;
            }
            
            if (nullOnNextLevel==true) counter++;
            if (counter == 3) return false;
            if (nextLevel.isEmpty()) return true;
            currLevel = nextLevel;
        }
    }
}
