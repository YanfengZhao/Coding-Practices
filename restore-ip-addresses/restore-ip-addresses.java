/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

// Solution 1. DFS recursion:
// Keep track of the current string, the index of character just added, and number of dots left.
// If number of dots left is 0, add everything remaining in the string to currString, check valid.
// Else, there are 3 cases and make a recursive call for each:
// 1. add a dot after adding 1 letter
// 2. add a dot after adding 2 letters
// 3. add a dot after adding 3 letters 

// Solution 2. Iterative:
// place the dots in every location by using the triple for loop.
// for each permutation check if it is valid by calling the method checkValid(int i, int j, int k, String s)
// which i j k are index and s is the string itself containing the dots.
// Also in this method, it calls another method createIP(int i, int j, int k, String s),
// if successful, checkValid returns the permutation to be added to the result, if not, it returns "fail"

public class Solution {
    List<String> resultS1 = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4 || s.length()>12){
            return resultS1;
        }
        helper(s,"",0,3);
        return resultS1;
    }
    
    public void helper(String s, String currString, int index, int dotsLeft){
        // base case, if number of dotsLeft is 0, append rest of String
    	// then check valid
        if(dotsLeft == 0){
        	// append the rest of the string to currString
        	if(index<s.length()){
        		currString += s.substring(index);
        	}
            if(valid(currString)){
                resultS1.add(currString);
            }
        }
        
        // 3 cases:
        // 1. add a dot after adding 1 letter
        // 2. add a dot after adding 2 letters
        // 3. add a dot after adding 3 letters 
        
        if(index < s.length()){
            helper(s, currString+s.charAt(index)+".", index+1, dotsLeft-1);
        }
        if(index+1 < s.length()){
            helper(s, currString+s.charAt(index)+s.charAt(index+1)+".", index+2, dotsLeft-1);
        }
        if(index+2 < s.length()){
            helper(s, currString+s.charAt(index)+s.charAt(index+1)+s.charAt(index+2)+".", index+3, dotsLeft-1);
        }
    }
    
    public boolean valid(String IP){
        String[] strArr = IP.split("\\.");
        if(strArr.length < 4){ // make sure the length is equal to 4
        	return false;
        }
        for(String str:strArr){
            if(str.length()>3 || (Integer.parseInt(str)>255) || (str.length()>1 && str.charAt(0)=='0')){
                return false;
            }
        }
        return true;
    }
    
    
    public List<String> restoreIpAddressesS2(String s) {
        List<String> result = new ArrayList<String>();
        // check length of s
        if(s.length()<4 || s.length()>12){
            return result;
        }
        // dot is after number's index
        for(int i=2; i<s.length()-1; i++){
            for(int j=1; j<i; j++){
                for(int k=0; k<j; k++){
                    String temp = checkValid(i,j,k,s);
                    if(!temp.equals("fail")){
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }
    public String checkValid(int i,int j,int k,String s){
        String IP = createIP(i,j,k,s);
        String[] strArr = IP.split("\\.");
        for(String str:strArr){
            if((Integer.parseInt(str)>255) || (str.length()>1 && str.charAt(0)=='0')){
                return "fail";
            }
        }
        return IP;
    }
    public String createIP(int i,int j,int k,String s){
        StringBuffer sb = new StringBuffer();
        for(int l=0; l<=s.length()-1; l++){
            sb.append(s.charAt(l));
            if(l == i || l == j || l == k){
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
