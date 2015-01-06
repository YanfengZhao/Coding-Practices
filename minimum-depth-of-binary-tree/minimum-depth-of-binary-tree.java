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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        ArrayList<TreeNode> currentLevel = new ArrayList<TreeNode>();
        currentLevel.add(root);
        int depth = 1;
        while(true){
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode node:currentLevel){
                if(node.left!=null) nextLevel.add(node.left);
                if(node.right!=null) nextLevel.add(node.right);
                if(node.left == null && node.right == null) {
                    return depth;
                }
            }
            depth++;
            currentLevel = nextLevel;
        }
    }
}
