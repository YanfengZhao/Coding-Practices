/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// recursive
/*public class Solution {
    private List<Integer> preorder = new LinkedList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return preorder;
        preorder.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return preorder;
    }
}*/

// iterative 
public class Solution{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode currNode = stack.pop();
            if(currNode != null){
                result.add(currNode.val);
                stack.push(currNode.right);
                stack.push(currNode.left);
            }
        }
        return result;
    }
}

// iterative 2
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return result;
        }
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
