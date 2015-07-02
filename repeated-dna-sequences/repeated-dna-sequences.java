/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

// The trick to this problem is to write your own encoding hashing function,
// because it cost a lot to map a 10 character string into a hash.
// So instead convert the 10 digit string to base 4 integer then use hashmap to count each pattern's occurance.

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < s.length()-9; i++){
            int encoded = hashing(s.substring(i,i+10));
            // if there is one instance of this in hashmap, add to result
            if(hm.containsKey(encoded) && hm.get(encoded) == 1){
                hm.put(encoded,hm.get(encoded)+1);
                result.add(s.substring(i,i+10));
            }
            // else does not contain or have more than one
            else{
                if(!hm.containsKey(encoded)){
                    hm.put(encoded,1);
                }
            }
        }
        return result;
    }
    
    public int hashing(String s){
        int sum = 0;
        for(int i = s.length() -1; i >= 0; i--) {
            if(s.charAt(i) == 'A') {
                sum *= 4;
            } else if(s.charAt(i) == 'C') {
                sum = sum * 4 + 1;
            } else if(s.charAt(i) == 'G') {
                sum = sum * 4 + 2;
            } else if(s.charAt(i) == 'T') {
                sum = sum * 4 + 3;
            }
        }
        return sum;
    }
}
