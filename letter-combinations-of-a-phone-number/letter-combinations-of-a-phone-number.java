public class Solution {
    private static final String[] LETTERS = {
        "",       // 0
        "",       // 1
        "abc",    // 2
        "def",    // 3
        "ghi",    // 4
        "jkl",    // 5
        "mno",    // 6
        "pqrs",   // 7
        "tuv",    // 8
        "wxyz"   // 9
    };
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        result.add("");
        for(char c : digits.toCharArray()) {
            String letters = LETTERS[c-'0'];
            ArrayList<String> newResult = new ArrayList<String>();
            for(char l : letters.toCharArray())
                for(String s : result)
                    newResult.add(s + l);
            result = newResult;
        }
        return result;
    }
}
