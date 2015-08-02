/*
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

// TrieNode holds 2 variable, 1 is array of type TrieNode with size 26, another is boolean variable isWord.
// When insert, starts at root, if the children[first_character - 'a'] is null, then create a new TrieNode for that location,
// and update current node to that node. If not null, simply set current node to that children node.
// After finishing traverse a whole word, set the isWord variable for that node = true.
// Notice the only difference between search for word and prefix function is the return line.

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

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
