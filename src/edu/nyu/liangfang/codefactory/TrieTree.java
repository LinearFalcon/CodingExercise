package edu.nyu.liangfang.codefactory;
import java.util.LinkedList;
import java.util.List;


class TrieNode {
    char letter;		// char corresponding to this node
    TrieNode[] links;	// 26 children array
    boolean fullWord;	// true if this is the last char of a full word
    
    TrieNode(char letter) {
        this.letter = letter;
        links = new TrieNode[26];
        this.fullWord = false;
    }
}

public class TrieTree {
    static TrieNode createTree() {
        return(new TrieNode('\0'));	// empty Trie Tree root
    }
    
    static void insertWord(TrieNode root, String word)
    {
        int offset = 97;	// ASCII code for 'a'
        int l = word.length();
        char[] letters = word.toCharArray();
        TrieNode curNode = root;
        
        for (int i = 0; i < l; i++)
        {
        	int pos = letters[i] - offset;
            if (curNode.links[pos] == null) {
                curNode.links[pos] = new TrieNode(letters[i]);
            }
            curNode = curNode.links[pos];
        }
        curNode.fullWord = true;  
    }

    static boolean find(TrieNode root, String word) {
        int offset = 97;
        TrieNode curNode = root;
        
        int i;
        for (i = 0; i < word.length(); i++) {
            if (curNode == null)
                return false;
            curNode = curNode.links[word.charAt(i) - offset];
        }
        
        if (i == word.length() && curNode == null) 	// miss last char
            return false;
        
        if (curNode != null && !curNode.fullWord)	// word is just a prefix
            return false;
        
        return true;
    }
    
    static List<String> getAllStringWithPrefix(TrieNode root, String prefix) {
    	List<String> result = new LinkedList<String>();
    	TrieNode curNode = root;
    	
    	for (int i = 0; i < prefix.length(); i++) {
    		if (curNode.links[prefix.charAt(i) - 'a'] == null) {
    			return result;
    		}
    		curNode = curNode.links[prefix.charAt(i) - 'a'];
    	}
    	
    	if (curNode.fullWord) {
    		result.add(prefix);
    	}
    	
    	List<String> postfixList = new LinkedList<String>();
    	getAllStringFromNode(curNode, postfixList, "");
    	for (String postfix : postfixList) {
    		result.add(prefix + postfix);
    	}
    	return result;
    }
    
    // Helper function for getAllStringWithPrefix() method
    // give list of string under this current node (exclusive)
    private static void getAllStringFromNode(TrieNode curNode, List<String> list, String curr) {
    	if (curNode != null) {
    		for (int i = 0; i < 26; i++) {
    			TrieNode next = curNode.links[i];
    			if (next != null) {
    				String newStr = curr + next.letter;
    				if (next.fullWord) {
    					list.add(newStr);
    				}
    			
    				getAllStringFromNode(next, list, newStr);
    			}
    		}
    	}
    }

	// DFS traverse the Trie tree and print all full words in the end of each branch
    static void printTree(TrieNode root, int level, char[] branch)
    {
        if (root == null)
            return;
        
        for (int i = 0; i < root.links.length; i++)
        {
            branch[level] = root.letter;
            printTree(root.links[i], level+1, branch);    
        }
        
        if (root.fullWord)
        {
        	// letter of first root of Trie tree is null, so start from 1
            for (int j = 1; j <= level; j++)
                System.out.print(branch[j]);
            System.out.println();
        }
    }
    
    public static void main(String[] args)
    {
        TrieNode tree = createTree();
        
        String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
        for (int i = 0; i < words.length; i++)
            insertWord(tree, words[i]);
        
//        char[] branch = new char[50];
//        printTree(tree, 0, branch);
//        
//        String searchWord = "all";
//        if (find(tree, searchWord)) {
//            System.out.println("The word was found");
//        } else {
//            System.out.println("The word was NOT found");
//        }
        
        System.out.println(getAllStringWithPrefix(tree, "all"));
    }
}