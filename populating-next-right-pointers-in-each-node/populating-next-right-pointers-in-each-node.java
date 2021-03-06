/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

// This solution is O(1) if recursion stack space isn't counted.
// The base case is that if root is null or left is null, then we are done.
// Then we first connect the left child and the right child.
// Secondly we check whether the current node has a next or not (because it would have been populated the previous layer).
// If it does, connect current node's right to next node's left.
// Repeat the this entire process for the current node's left node and right node.

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root != null && root.left != null){
            root.left.next = root.right;
            if (root.next != null){
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
    }
}
 
// bfs. Level by level.
// don't forget to make sure root is not null.

public class Solution {
    public void connect(TreeLinkNode root) {
        ArrayList<TreeLinkNode> currLevel = new ArrayList<TreeLinkNode>();
        currLevel.add(root);
        if(root!=null){
            while(!currLevel.isEmpty()){
                ArrayList<TreeLinkNode> nextLevel = new ArrayList<TreeLinkNode>();
                for(int i = 0; i < currLevel.size(); i++){
                    if(currLevel.get(i).left!=null){ // only need to check left since it's perfect tree
                        nextLevel.add(currLevel.get(i).left);
                        nextLevel.add(currLevel.get(i).right);
                    }
                    if(i == currLevel.size()-1){
                        currLevel.get(i).next = null;
                    }
                    else{
                        currLevel.get(i).next = currLevel.get(i+1);
                    }
                }
                currLevel = nextLevel;
            }
        }
    }
}
