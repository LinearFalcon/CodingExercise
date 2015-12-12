package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class substringWithConcatenationOfAllWords {
	
	// Brutal Force: 算法的时间复杂度是O（n*(l*k)）n是字符串的长度，l是单词的个数，k是单词的长度
	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> list = new ArrayList<Integer>();
        int len = L.length;
        if (len == 0) {
            return list;
        }
        int wordLen = L[0].length();
        
        Hashtable<String, Integer> srcTable = new Hashtable<String, Integer>();	// use map may be better
        Hashtable<String, Integer> foundTable = new Hashtable<String, Integer>();
        // store the frequency of each word in L array
        for (int i = 0; i < len; i++) {             
            if (!srcTable.containsKey(L[i])) {
                srcTable.put(L[i], 1);
            } else {
                srcTable.put(L[i], srcTable.get(L[i]) + 1);
            }
        }
        // check each substring of S that starts from i
        for (int i = 0; i <= S.length() - len * wordLen; i++) {
            foundTable.clear();         // Must firstly clear foundTable
            int j;
            for (j = 0; j < len; j++) {
                int k = i + j * wordLen;	// start pos of this word
                String sub = S.substring(k, k + wordLen);
                
                if (!srcTable.containsKey(sub)) break;   // not in L array, break and see rest of S

                // update fonudTable
                if (!foundTable.containsKey(sub)) {
                    foundTable.put(sub, 1);
                } else {
                    foundTable.put(sub, foundTable.get(sub) + 1);
                }
                
                if (foundTable.get(sub) > srcTable.get(sub)) break;  // if found more words than L, break
            }
            
            if (j == len) {     // only when for j loop executes properly is this i a valid start
                list.add(i);    // position of substring formed by all words from L
            }
        }
        
        return list;
    }
	
	
	
	// Don't understand yet!!!!!!!!!
	
/*
因为L中所有单词的长度是一样的，这样根据wordLen，可以将S分为wordLen组，实际意思是这样的。

以题目中barfoothefoobarman举例，L中单词长度为3，可以分为
bar|foo|the|foo|bar|man
ba|rfo|oth|efo|oba|rma|n
b|arf|oot|hef|oob|arm|an
这样，针对每个分组，可以利用最小滑动窗口的思想，快速的判断是否包含需要的字符串。
直观上来看，1和2好像都是需要从每个字符开始搜索，实际上，2利用两个指针去在S中寻找满足条件的字符串，并且是每次+wordLen，而且不会重复的去统计，节省了很多时间。
	 */
	public List<Integer> findSubstring_BetterSolution(String S, String[] L) {
        ArrayList<Integer> list = new ArrayList<Integer>();  
        int len = L.length;  
        if (len == 0) {  
            return list;  
        }  
        int wordLen = L[0].length();  
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();  
        for (int i = 0; i < len; i++) {  
            int num = 1;  
            if (wordsMap.get(L[i]) != null) {  
                num += wordsMap.get(L[i]);  
            }  
            wordsMap.put(L[i], num);  
        }  
        int slen = S.length();  
        int max = slen - wordLen + 1;  
        for (int i = 0; i < wordLen; i++) {  
            Map<String, Integer> numMap = new HashMap<String, Integer>();  
            int count = 0;  
            int start = i;  
            for (int end = start; end < max; end += wordLen) {  
                String tempStr = S.substring(end, end + wordLen);  
                if (!wordsMap.containsKey(tempStr)) {  
                    numMap.clear();  
                    count = 0;  
                    start = end + wordLen;  
                    continue;  
                }  
                int num = 1;  
                if (numMap.containsKey(tempStr)) {  
                    num += numMap.get(tempStr);  
                }  
                numMap.put(tempStr, num);  
                if (num <= wordsMap.get(tempStr)) {  
                    count++;  
                } else {  
                    while (numMap.get(tempStr) > wordsMap.get(tempStr)) {  
                        tempStr = S.substring(start, start + wordLen);  
                        numMap.put(tempStr, numMap.get(tempStr) - 1);  
                        if (numMap.get(tempStr) < wordsMap.get(tempStr)) {  
                            count--;  
                        }  
                        start += wordLen;  
                    }  
                }  
                if (count == len) {  
                    list.add(start);  
                    tempStr = S.substring(start, start + wordLen);  
                    numMap.put(tempStr, numMap.get(tempStr) - 1);  
                    count--;  
                    start += wordLen;  
                }   
            }  
        }  
        return list;  
    }
}
