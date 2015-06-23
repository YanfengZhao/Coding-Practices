public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        HashMap<String,String> hm = new HashMap<String,String>();
        for(String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(hm.containsKey(sorted)){
                result.add(s);
                if(!hm.get(sorted).equals("0")){
                    result.add(hm.get(sorted));
                    hm.put(sorted,"0");
                }
            }
            else{
                hm.put(sorted,s);
            }
        }
        return result;
    }
}
