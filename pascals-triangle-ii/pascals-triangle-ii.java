/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

// Online Solution
public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
     
    	if (rowIndex < 0)
    		return result;
     
    	result.add(1);
    	for (int i = 1; i <= rowIndex; i++) {
    		for (int j = result.size() - 2; j >= 0; j--) {
    			result.set(j + 1, result.get(j) + result.get(j + 1));
    		}
    		result.add(1);
    	}
    	return result;
    }
}

// My Solution
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<rowIndex+1;i++) {
            res.add(1);
            for(int j=i-1;j>0;j--) {
                res.set(j, res.get(j-1)+res.get(j));
            }
        }
        return res;
    }
}
