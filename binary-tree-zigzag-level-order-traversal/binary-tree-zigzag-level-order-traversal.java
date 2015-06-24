/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> curLevel = new ArrayList<TreeNode>();
        
        if(root == null){
            return result;
        }
        
        curLevel.add(root);
        boolean reversed = false;
        
        while(curLevel.size() > 0){
            
            // create the next level
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode n:curLevel){
                if(n.left!=null){
                    nextLevel.add(n.left);
                }
                if(n.right!=null){
                    nextLevel.add(n.right);
                }
            }
            // add the current level to the list
            if(reversed == true){
                Collections.reverse(curLevel);
            }
            
            List<Integer> curLevelInt = new ArrayList<Integer>();
            for(TreeNode n:curLevel){
                curLevelInt.add(n.val);
            }
            result.add((ArrayList<Integer>)curLevelInt);
            
            // update current level and decide reverse for next level
            curLevel = nextLevel;
            reversed = !reversed;
        }
        return result;
    }
}
