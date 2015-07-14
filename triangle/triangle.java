/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

// Dynamic programming keeps track of the least possible sum at each location in the previous row.
// Find the least element in prev at the end.
// O(n) space.

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<Integer> prev = new ArrayList<Integer>(triangle.get(0));
        // fill in curr with the least possible sum at each location and update prev
        for(int i = 1; i < triangle.size(); i++){
        	ArrayList<Integer> curr = new ArrayList<Integer>(triangle.get(i));
            
        	for(int j = 0; j <= i; j++){
        		if(j == 0){
        			curr.set(j, curr.get(j)+prev.get(j));
        		}
        		else if(j == i){
        			curr.set(j, curr.get(j)+prev.get(j-1));
        		}
        		else{
        			curr.set(j, curr.get(j)+Math.min(prev.get(j), prev.get(j-1)));
        		}
        	}
        	prev = curr;
        }
        
        // traverse the last row to find the smallest element
        int result = prev.get(0);
        for(int i = 1; i < triangle.size(); i++){
        	if(result > prev.get(i)){
        		result = prev.get(i);
        	}
        }
        return result;
    }
}
