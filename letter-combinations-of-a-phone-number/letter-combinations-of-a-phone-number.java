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

// recursion
public class Solution {
    public List<String> result = new ArrayList<String>();
    public String[] dict = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        dfs(digits,"");
        return result;
    }
    
    public void dfs(String digits, String build){
        if(digits.length()==build.length()){
            if(build.length()>0)
                result.add(build);
            return;
        }
        int cur = build.length();
        int currDigit = digits.charAt(cur) - '0';
        String perm = dict[currDigit];
        for(int i = 0; i < perm.length(); i++){
            dfs(digits,build+perm.charAt(i));
        }
        return;
    }
}
