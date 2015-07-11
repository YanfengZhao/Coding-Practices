/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

// use Dynamic Programming. M[i] = M[j] * M[i-1-j]
// Everytime you add a new node to the tree, you have every location. For example:
// You have 1, 2, and 3 in the tree. You are inserting 4, you can have
// 4123, 1423, 1243, 1234
// Respectively, you have 
// number of ways to arrange 0 (1) * num of ways to arrage 123 (5), plus 
// number of ways to arrange 1 (1) * num of ways to arrage 23 (2), plus
// number of ways to arrange 12 (2) * num of ways to arrage 3 (1), plus
// number of ways to arrange 123 (5) * num of ways to arrage 0 (1), plus

public class Solution {
     public int numTrees(int n) {
        int[] M = new int[n + 1];
        if(n == 0 || n == 1){
            return n;
        }
        M[0] = 1;
        M[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0;j <=i-1;j++){                        // one node can be inserted at 0 -> i-1 different locations
                M[i] += M[j]*M[i - 1 - j];                   // remeber it is * rather than +,
            }
        }
        return M[n];
    }
}
