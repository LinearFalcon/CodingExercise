package edu.nyu.liangfang.leetcode;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;


public class letterCombinationsOfPhoneNumber {
    // current version
    public List<String> letterCombinations(String digits) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> rst = new ArrayList<>();
        if (digits.length() != 0) compute(digits, 0, "", rst, map);
        return rst;
    }

    private void compute(String digits, int index, String curr, List<String> rst, String[] map) {
        if (index == digits.length()) {
            rst.add(curr);
            return;
        }

        String mapping = map[digits.charAt(index) - '0'];
        for (int i = 0; i < mapping.length(); i++) {
            compute(digits, index + 1, curr + mapping.charAt(i), rst, map);
        }
    }


    // ---------------------- previous version ----------------------
    public List<String> letterCombinations2(String digits) {
        Hashtable<Character, String> table = new Hashtable<Character, String>();
        table.put('0', "");
        table.put('1', "");
        table.put('2', "abc");
        table.put('3', "def");
        table.put('4', "ghi");
        table.put('5', "jkl");
        table.put('6', "mno");
        table.put('7', "pqrs");
        table.put('8', "tuv");
        table.put('9', "wxyz");

        List<String> list = new LinkedList<String>();
        generate(table, list, "", 0, digits);
        return list;
    }

    private void generate(Hashtable<Character, String> table, List<String> list, String currentStr, int index, String digits) {
        if (index >= digits.length()) {
            list.add(currentStr);
            return;
        }

        char letter = digits.charAt(index);
        String possibilities = table.get(letter);
        for (int i = 0; i < possibilities.length(); i++) {
            generate(table, list, currentStr + possibilities.charAt(i), index + 1, digits);
        }

    }
}
