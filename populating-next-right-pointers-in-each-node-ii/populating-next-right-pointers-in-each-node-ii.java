/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
// bfs. Level by level.
// don't forget to make sure root is not null.

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        ArrayList<TreeLinkNode> curLevel = new ArrayList<TreeLinkNode>();
        curLevel.add(root);
        while(curLevel.size()>0){
            ArrayList<TreeLinkNode> nextLevel = new ArrayList<TreeLinkNode>();
            for(int i = 0; i < curLevel.size(); i++){
                // if the node is last one in the row, set next to null, else set next to next in list
                if(i == curLevel.size()-1){
                    curLevel.get(i).next = null;
                }
                else{
                    curLevel.get(i).next = curLevel.get(i+1);
                }
                if(curLevel.get(i).left!=null){
                    nextLevel.add(curLevel.get(i).left);
                }
                if(curLevel.get(i).right!=null){
                    nextLevel.add(curLevel.get(i).right);
                }
            }
            curLevel = nextLevel;
        }
    }
}
