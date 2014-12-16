package edu.nyu.liangfang.leetcode;

class TrieNode {
    char c;
    TrieNode[] links;
    boolean fullWord;
    public TrieNode(char c) {
        this.c = c;
        this.links = new TrieNode[26];
        this.fullWord = false;
    }
}
// Assume all lowercase
class TrieTree {
    TrieNode root = new TrieNode('\0');
    
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int pos = ch - 'a';
            if (curr.links[pos] == null) {
                curr.links[pos] = new TrieNode(ch);
            }
            curr = curr.links[pos];
        }
        curr.fullWord = true;
    }
    
    public String prefix() {
        TrieNode curr = root;
        if (curr.fullWord) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        while (true) {
            int count = 0;
            boolean isFullWord = false;
            TrieNode node = null;
            for (TrieNode child : curr.links) {
                if (child != null) {
                    count++;
                    node = child;
                    if (child.fullWord) {
                        isFullWord = true;
                    }
                }
            }
            if (count != 1) {
                break;
            }
            sb.append(node.c);
            if (isFullWord) {
                break;
            }
            curr = node;
        }
        return sb.toString();
    }
}

public class longestCommonPrefix_TrieTree {
    public String longestCommonPrefix(String[] strs) {
        TrieTree tree = new TrieTree();
        for (String s : strs) {
            tree.insert(s);
        }
        return tree.prefix();
    }
}