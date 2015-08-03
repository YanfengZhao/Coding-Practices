/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
*/

// Use a trie data structure
// Backtracking recursion when searching for words.
// Be careful of the base case:
// If index == length and cur is a word, return true, if cur is not a word, then return false.

public class WordDictionary {
	public class TrieNode{
        boolean isWord;
        TrieNode[] children;
        
        public TrieNode(){
            isWord = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode(); // initialize the trie
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            // if the character already exist, then reuse
            if(cur.children[c-'a'] != null){
                cur = cur.children[c-'a'];
            }
            // if the character doesn't exist, create a new trieNode and store in children
            else{
                TrieNode node = new TrieNode();
                cur.children[c-'a'] = node;
                cur = cur.children[c-'a'];
            }
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode cur = root;
        return helper(word,cur,0);
    }
    
    public boolean helper(String word, TrieNode cur, int index){
        
        // base case, if index == length and cur is a word
        if(index == word.length()){
            if(cur.isWord == true){
                return true;
            }
            else{
                return false;
            }
        }
        
        char c = word.charAt(index);
        // if a wild card, call the recursive function on every child trienode that is available
        if(c == '.'){
            boolean result = false;
            for(int i = 0; i < 26; i++){
                
                if(cur.children[i]!=null){
                    result |= helper(word,cur.children[i],index+1);
                }
            }
            return result;
        }
        // else find the TrieNode in the location and see if it exist
        else{
            if(cur.children[c-'a'] == null){
                return false;
            }
            else{
                return helper(word,cur.children[c-'a'],index+1);
            }
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
