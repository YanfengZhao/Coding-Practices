/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

// This solution works but time limit exceeds.
// The idea is calculate every permutation until K is reached.

public class Solution {
    int glob;
    String result = "";
    boolean found = false;
    public String getPermutation(int n, int k) {
        glob = k;
        helper(n,new ArrayList<Integer>());
        return result;
    }
    
    public void helper(int n, ArrayList<Integer> currArr){
        if(currArr.size() == n){
            glob--;
            if(glob>=0){
                StringBuilder sb = new StringBuilder();
                for(int i:currArr){
                    sb.append(i);
                }
                result = sb.toString();
                if(glob == 0){
                    found = true;
                }
            }
            return;
        }
        
        for(int i = 1; i <= n; i++){
            if(!currArr.contains(i)){
                currArr.add(i);
                helper(n,currArr);
                if(found == true){
                    return;
                }
                currArr.remove(currArr.size()-1);
            }
        }
    }
}
