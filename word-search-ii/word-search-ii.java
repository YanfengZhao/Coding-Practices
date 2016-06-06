/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

Hint:

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
*/

// 1. Create a Trie data structure and add every word into trie.
// 2. For every character in the grid, search all direction for words.
// 3. If no word start with current letters (trie.startWith(currWord)), return
// 4. If there is, check if it is a word.
// Make sure create a set so there is no duplicated words.

public class Solution {
    private List<String> result = new ArrayList<String>();
    private HashSet<String> hs = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0){
            return result;
        }
        Trie trie = new Trie();
        for (String word : words){
            trie.insert(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                helper (trie, board, visited, "", i, j);
            }
        }
        for(String s : hs){
            result.add(s);
        }
        return result;
    }
    
    public void helper(Trie trie, char[][] board, boolean[][] visited, String cur, int i, int j){
        if (i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1 || visited[i][j]){
            return;
        }
        
        String newWord = cur + board[i][j];
        if(!trie.startsWith(newWord)){
            return;
        }
        if(trie.search(newWord)){
            hs.add(newWord);
	    }
        
        visited[i][j] = true;
        helper(trie, board, visited, newWord, i+1, j);
        helper(trie, board, visited, newWord, i-1, j);
        helper(trie, board, visited, newWord, i, j+1);
        helper(trie, board, visited, newWord, i, j-1);
        visited[i][j] = false;
    }
    
    class TrieNode {
        // Initialize your data structure here.
    
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    public class Trie {
        private TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
    
        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.children[c-'a'] == null){
                    // if the node doesn't exist, create a new node to store it
                    TrieNode n = new TrieNode();
                    cur.children[c-'a'] = n;
                    cur = n;
                }
                
                else{
                    cur = cur.children[c-'a'];
                }
            }
            cur.isWord = true;
        }
    
        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode cur = root;
            for(int i = 0 ; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.children[c-'a'] == null){
                    return false;
                }
                else{
                    cur = cur.children[c-'a'];
                }
            }
            return cur.isWord;
        }
    
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for(int i = 0 ; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if(cur.children[c-'a'] == null){
                    return false;
                }
                else{
                    cur = cur.children[c-'a'];
                }
            }
            return true;
        }
    }
}
