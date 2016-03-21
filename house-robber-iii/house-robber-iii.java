/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
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
 
// Use a hashmap to keep track of the calculated nodes.
// Use DFS. You can rob 4 different houses: left.left, left.right, right.left, right.right.
// Be careful you don't necessarily pick every node in one level, so BFS doesn't work.

public class Solution {
    HashMap<TreeNode,Integer> hm = new HashMap<TreeNode,Integer>();
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        if(hm.containsKey(root)){
            return hm.get(root);
        }
        int val = 0;
        if(root.left != null){
            val = val + rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            val = val + rob(root.right.left) + rob(root.right.right);
        }
        
        int result = Math.max(rob(root.left)+rob(root.right),root.val+val);
        hm.put(root,result);
        return result;
    }
}
