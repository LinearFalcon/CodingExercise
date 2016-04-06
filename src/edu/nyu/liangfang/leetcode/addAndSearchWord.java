class TrieNode {
    // Initialize your data structure here.
    public char ch;
    public TrieNode[] map = new TrieNode[26];
    boolean hasWord = false;

    public TrieNode() {
        ch = '\0';
    }

    public TrieNode(char c) {
        ch = c;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.map[ch - 'a'] == null)
                node.map[ch - 'a'] = new TrieNode(ch);
            node = node.map[ch - 'a'];
        }
        node.hasWord = true;
    }

    public boolean patternSearch(String word) {
        return find(word, root);
    }

    private boolean find(String word, TrieNode root) {
        if (word.length() == 0) return root.hasWord;
        char c = word.charAt(0);
        String nextStr = word.substring(1);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.map[i] != null && find(nextStr, root.map[i])) return true;
            }
        } else {
            return root.map[c - 'a'] != null && find(nextStr, root.map[c - 'a']);
        }
        return false;
    }
}

/* Main Function */
public class WordDictionary {
    Trie trie = new Trie();

    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trie.patternSearch(word);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");