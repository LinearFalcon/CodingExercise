package edu.nyu.liangfang.codefactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * given a list of words, find palindome pairs 就是说给你一个字典，
 * 让你找出里面所有的pair<word1, word2>使得word1和word2拼到一起是一个palindrome。
 * 
 * eg:abc和cba 这种算一个pair，ab 和 ccccccccba 也算一个pair
 */

// Solution: 对一个词遍历所有partition情况，两个substring，一个一个判断是不是
// palindrome，如果是就reverse另一个substring然后看在不在set里面，在就是一对

public class palindromePairs {
    public List<stringPair> palindromePair(List<String> words) {
        List<stringPair> rst = new ArrayList<stringPair>();
        Set<String> set = new HashSet<String>();

        for (String s : words) {    // add all words to HashSet
            set.add(s);
        }

        for (String word : words) {    // iterate over each string
            for (int i = 0; i < word.length(); i++) {            // if assume no empty string in words, then i starts from 1
                String sub1 = word.substring(0, i);
                String sub2 = word.substring(i);

                if (isPalin(sub1)) {
                    String reverse = new StringBuilder(sub2).reverse().toString();
                    if (set.contains(reverse)) {
                        rst.add(new stringPair(reverse, word));
                    }
                }

                if (isPalin(sub2)) {
                    String reverse = new StringBuilder(sub1).reverse().toString();
                    if (set.contains(reverse)) {
                        rst.add(new stringPair(word, reverse));
                    }
                }
            }
        }

        return rst;
    }

    private boolean isPalin(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        palindromePairs obj = new palindromePairs();
        List<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("cba");
        list.add("ab");
        list.add("ccccba");
        list.add("bacc");
        List<stringPair> rst = obj.palindromePair(list);

        for (stringPair p : rst) {
            System.out.println(p.s1 + " " + p.s2);
        }
    }
}
