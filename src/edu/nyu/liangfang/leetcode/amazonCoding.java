package edu.nyu.liangfang.leetcode;

public class amazonCoding {
    public String removeVowel(String s) {
        StringBuilder sb = new StringBuilder();
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (vowels.indexOf(ch) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public int isGrayCode(byte element1, byte element2) {
        byte res = (byte) (element1 ^ element2);
        for (int i = 0; i <= 7; i++) {
            byte temp = (byte) (1 << i);
            if (temp == res) {
                return 1;
            }
        }
        System.out.println("No");
        return 0;
    }

    public int isRotation(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) {
            return -1;
        } else if (word1.length() != word2.length()) {
            return -1;
        }
        String str = word1 + word1;
        return str.indexOf(word2) != -1 ? 1 : -1;
    }
}
