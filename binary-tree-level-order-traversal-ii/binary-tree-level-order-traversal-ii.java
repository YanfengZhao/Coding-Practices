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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> level = new ArrayList<TreeNode>();
        if(root == null) return result;
        level.add(root);
        
        while(true){
            if(level.isEmpty()) break;
            
            List<Integer> currLevel = new ArrayList<Integer>();
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode node:level){
                currLevel.add(node.val);
                if(node.left != null) nextLevel.add(node.left);
                if(node.right != null) nextLevel.add(node.right);
            }
            
            result.add(0,currLevel);
            level = nextLevel;
        }
        
        return result;
    }
}
