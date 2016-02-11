/*
One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
*/

// Have a counter and treat it like stack.
// Notice the number of "#" at the end of the computation is always one more than the nodes in the tree.
// Every time "#" appears, decrement the counter.
// Otherwise:
// if counter is less than 0, it means either you started with a "#" followed by numbers, or there are more "#" than numbers,
// which are both invalid, so return false,
// and increment the counter.

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int counter = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i].equals("#")){
                counter--;
            }
            else{
                if (counter < 0) { // check
                    return false;
                }
                counter++;
            }
        }
        return counter == -1; // "#" should always be one more than number of nodes in the tree
    }
}
