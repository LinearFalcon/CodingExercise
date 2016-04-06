package edu.nyu.liangfang.codefactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class sortByGivenString {
    public void sort(String[] A, String s) {    // given string s has length of 26, 26 letters
        if (s.length() == 0) return;

        final Map<Character, Integer> map = new HashMap<Character, Integer>();    // If want to be used in compare, must declare final !!!!!!
        for (int i = 0; i < s.length(); i++) {                                // final variable can only be initialized once
            map.put(s.charAt(i), i);
        }

        Arrays.sort(A, new Comparator<String>() {
            public int compare(String s1, String s2) {
                int shortLen = Math.min(s1.length(), s2.length());
                for (int i = 0; i < shortLen; i++) {
                    int n1 = map.get(s1.charAt(i));
                    int n2 = map.get(s2.charAt(i));
                    if (n1 != n2) {
                        return n1 - n2;
                    }
                }

                if (s1.length() == s2.length()) {
                    return 0;
                }

                return s1.length() - s2.length();
            }
        });
    }


    // ----- test -----
    public static void main(String[] args) {
        sortByGivenString o = new sortByGivenString();
        String s = "abcdefghijklmnopqrstuvwxyz";
        String s2 = new StringBuilder(s).reverse().toString();
        String[] A = {"face", "ball", "apple", "art", "ah"};
        o.sort(A, s2);

        for (String l : A)
            System.out.println(l);
    }
}
