public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int length = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(start,map.get(c) + 1);
            }
            length = Math.max(length, i-start+1);
            map.put(c,i);
        }
        return length;
    }
}
