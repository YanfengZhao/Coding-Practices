/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

// solution that's easy to understand:

public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows < 1){
            return result;
        }
        ArrayList<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        result.add(prev);
        if(numRows == 1){
            return result;
        }
        for(int i = 2; i <= numRows; i++){
            ArrayList<Integer> curRow = new ArrayList<Integer>();
            curRow.add(1);
            for(int j = 0; j < prev.size()-1;j++){
                curRow.add(prev.get(j)+prev.get(j+1));
            }
            curRow.add(1);
            result.add(curRow);
            prev = curRow;
        }
        return result;
    }
}
// no need to make special case for row 1 and row 2.
// traverse each row, and reuse the row from above and keep building off of it.
// remember at the beginning of each row, add a 1 in front of it.
// only create a new row when adding to result.

public class Solution {
    public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		
		if(numRows < 1){
			return result;
		}
		// traverse each row
		for(int i = 0; i < numRows; i++){
		    // always append a 1 in front for each row
			row.add(0,1);
			// build each row
			for(int j = 1; j < row.size() - 1; j++){
				row.set(j, row.get(j)+row.get(j+1));
			}
			result.add(new ArrayList<Integer>(row));
		}
		return result;
    }
}
