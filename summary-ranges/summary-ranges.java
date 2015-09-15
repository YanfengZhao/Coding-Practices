/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

// Solution 1, better solution.
// Have a while loop.
// First check if it is the last element OR next element is not consecutive.
// You have to check if StringBuilder is empty or not and deal with it accordingly.
// Else it is not the end and next is consecutive then add the number to stringbuilder only if sb is empty.

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums.length == 0){
            return result;
        }
        
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i<nums.length){
            if(i+1==nums.length || nums[i+1]-1 != nums[i]){ // last num
                if(sb.length()==0){
                    sb.append(nums[i]);
                    result.add(sb.toString());
                    sb.setLength(0);
                }
                else{
                    sb.append("->");
                    sb.append(nums[i]);
                    result.add(sb.toString());
                    sb.setLength(0);
                }
            }
            else { // if this is not end and next is consecutive
                if(sb.length() == 0){ // first one in sequence
                    sb.append(nums[i]);
                }
            }
            i++;
        }
        return result;
    }
}

// Solution 2, a bit confusing
public class Solution {
    public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if(nums.length==0){
			return result;
		}
       
		int saved = 1; // keep track of how many consecutives have counted so far
		StringBuilder sb = new StringBuilder();
		sb.append(nums[0]);
        for(int i = 1; i<nums.length; i++){
            // if this int is consecutive of last int, add counter
            // if not, see what the saved value is and add the corresponding text to result
        	if((nums[i-1]+1 != nums[i])){
        		if(saved == 1){
        			result.add(sb.toString());
        			sb.setLength(0);
        			sb.append(nums[i]);
        			saved = 1;
        		}
        		else{
        			result.add(sb.append("->" + nums[i-1]).toString());
        			sb.setLength(0);
        			sb.append(nums[i]);
        			saved = 1;
        		}
        	}
        	else{
        		saved++;
        	}
        }
        // deal with the last set of numbers that haven't been added to result
        if(saved == 1){
        	result.add(sb.toString());
        }
        else{
        	result.add(sb.append("->" + nums[nums.length-1]).toString());
        }
        
        return result;
    }
}
