package edu.nyu.liangfang.codefactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Yahoo问题：在一个string a 里找到所有string b的permutation 的 出现位置， 比如 a = abcdcba, b= abc, 那么返回0， 4
// 类似minimum window substring, 用srcTable, foundMap和foundNum来解决，相当于双指针，一个i一个start
public class findPermutationPosition {
    public List<Integer> findPermPos(String S, String T) {
        List<Integer> list = new LinkedList<Integer>();
        int[] srcTable = new int[256];
        Map<Character, Integer> foundMap = new HashMap<Character, Integer>();
        int foundNum = 0;

        // initialize srcTable
        for (int i = 0; i < T.length(); i++) {
            srcTable[T.charAt(i)]++;
        }

        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            Character ch = S.charAt(i);
            if (srcTable[ch] == 0) {
                foundMap.clear();
                foundNum = 0;
                start = i + 1;
            } else {
                // increment foundMap
                if (!foundMap.containsKey(ch)) {
                    foundMap.put(ch, 1);
                } else {
                    foundMap.put(ch, foundMap.get(ch) + 1);
                }

                if (foundMap.get(ch) > srcTable[ch]) {    // if found redundant chars, move start forward
                    while (start < i && S.charAt(start) != ch) {
                        foundNum--;
                        foundMap.put(S.charAt(start), foundMap.get(S.charAt(start)) - 1);
                        start++;
                    }
                    foundMap.put(S.charAt(start), foundMap.get(S.charAt(start)) - 1);    // start again from the char after first appearing ch position
                    start++;
                } else {
                    foundNum++;

                    if (foundNum == T.length()) {    // we found one permutation
                        list.add(start);
                        foundNum--;
                        foundMap.put(S.charAt(start), foundMap.get(S.charAt(start)) - 1);
                        start++;        // do not set to i+1, since you may have this intput ("abca", "abc"), output should be [0,1]
                    }
                }
            }
        }
        return list;
    }
}
