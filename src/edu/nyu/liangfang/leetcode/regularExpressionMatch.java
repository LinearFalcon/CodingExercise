package edu.nyu.liangfang.leetcode;

public class regularExpressionMatch {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // length == 1 is the case that is easy to forget.
        // as p is subtracted 2 each time, so if original
        // p is odd, then finally it will face the length 1
        if (p.length() == 1) {
            return (s.length() == 1)
                    && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }

        // next char is not '*': must match current character
        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return false;
            } else {
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                        && isMatch(s.substring(1), p.substring(1));
            }
        } else {
            // check if p[0-1] matches 0 or more leading characters of s
            while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {    // p[0-1] is ".*" situation
                    return true;
                }
                s = s.substring(1);        // match one leading char of s
            }

            // if next char is * and s.charAt(0) != p.charAt(0) and p.charAt(0) != ‘.' or s is empty now
            return isMatch(s, p.substring(2));
        }
    }

    public boolean isMatch_DP(String s, String p) {    // assume p is valid input, no invalid string like "*abc"
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];   // dp[i][j] means isMatch( s[0,i), p[0,j) ), i and j is number not index

        dp[0][0] = true;
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i - 1][j - 1];
                } else {            // 检查p后面这两个char：x*是否能匹配s
                    dp[i][j] |= dp[i][j - 2];    // 双层循环遍历所有情况，所以当p当前char是'*'的时候，只需要or前面两种情况
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }

        return dp[sLen][pLen];
    }


    public static void main(String[] args) {
        regularExpressionMatch o = new regularExpressionMatch();
        System.out.println(o.isMatch_DP("", ".*"));
    }
}
