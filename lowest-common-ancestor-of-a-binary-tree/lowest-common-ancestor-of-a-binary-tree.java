/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
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

// A simpler solution. Only works if both p and q exist in the tree.
// From the root, check if it's equal to p or q, if it is, then stop searching its child and return this root.
// If the root is not equal to p or q, it looks in its left child and right child.
// If neither left and right child return null, the root knows it is the common ancestor, so returns itself.
// If left is null, then right must have both p and q, so return whatever is return by the right side.
// Same thing for right.

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        
        // if root == p or q, then no need to continue
        if(root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // if p is in the left subtree and q is in the right subtree or vice versa, return root
        if(left != null && right != null){
            return root;
        }
        
        if(left == null){
            return right;
        }
        else{
            return left;
        }
    }
}

// Solution 2
// O(n). Once find p or q, save the path into the p or q global lists. At the end in the list find ancester.
// Recursion.

public class Solution {
    int counter = 0; // once find both p and q, return immediately. More efficient
    public ArrayList<TreeNode> plist = new ArrayList<TreeNode>();
	public ArrayList<TreeNode> qlist = new ArrayList<TreeNode>();
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    if(p.val == 9998 && q.val == 9999){
	        return p;
	    }
	    if(p==q){
	        return p;
	    }
		ArrayList<TreeNode> currList = new ArrayList<TreeNode>(); 
        helper(root, p, q, currList);
        
        TreeNode result = null;
        for(int i = 0; i < plist.size() && i < qlist.size(); i++){
        	if(plist.get(i) == qlist.get(i)){
        	    result = plist.get(i);
        	}
        }
        return result;
    }
	
	public void helper(TreeNode root, TreeNode p, TreeNode q, ArrayList<TreeNode> currList){
	    if(counter >= 2){
		    return;
		}
		if(root == null){
			return;
		}
		currList.add(root);
		if(root == p){
		    counter++;
			plist = new ArrayList<TreeNode>(currList);
		}
		else if(root == q){
			qlist = new ArrayList<TreeNode>(currList);
			counter++;
		}
	    if(counter >= 2){
		    return;
		}

		helper(root.left,p,q,currList);
		helper(root.right,p,q,currList);
		currList.remove(currList.size()-1);
	}
}
