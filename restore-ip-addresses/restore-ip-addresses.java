/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

// place the dots in every location by using the triple for loop.
// for each permutation check if it is valid by calling the method checkValid(int i, int j, int k, String s)
// which i j k are index and s is the string itself containing the dots.
// Also in this method, it calls another method createIP(int i, int j, int k, String s),
// if successful, checkValid returns the permutation to be added to the result, if not, it returns "fail"
  
public class Solution {
    public List<String> restoreIpAddresses(String s) {
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
