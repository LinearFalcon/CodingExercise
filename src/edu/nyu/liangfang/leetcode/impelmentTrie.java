class TrieNode {
    // Initialize your data structure here.
    public char ch;
    public TrieNode[] map = new TrieNode[26];       // faster than using HashMap
    boolean hasWord = false;
    public TrieNode() {
        ch = '\0';
    }
    public TrieNode(char c) {
        ch = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if  (node.map[ch - 'a'] == null) 
                node.map[ch - 'a'] = new TrieNode(ch);
            node = node.map[ch - 'a'];
        }
        node.hasWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.map[ch - 'a'] == null) return false;
            node = node.map[ch - 'a'];
        }
        return node.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.map[ch - 'a'] == null) return false;
            node = node.map[ch - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");