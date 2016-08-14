/*
 Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            if (hm.containsKey(c)){
                hm.put(c, hm.get(c) + 1);
            } else {
                hm.put(c, 1);
            }
        }
        
        for (int i = 0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if (!hm.containsKey(c) || hm.get(c) == 0){
                return false;
            } else {
                hm.put(c, hm.get(c) - 1);
            }
        }
        
        return true;
    }
}
