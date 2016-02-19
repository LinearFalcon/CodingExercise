package edu.nyu.liangfang.leetcode;
import java.util.Stack;


public class longestValidParentheses {
    // slow solution with two stacks, almost 20ms
    public int longestValidParentheses1(String s) {
        Stack<Integer> indexSt = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!indexSt.isEmpty() && s.charAt(indexSt.peek()) == '(' && s.charAt(i) == ')') {
                indexSt.pop();
            } else {
                indexSt.push(i);
            }
        }
        
        if (indexSt.isEmpty()) return s.length();
        int max = 0, end = s.length();
        while (!indexSt.isEmpty()) {
            int index = indexSt.pop();
            if (end - index - 1 > max) max = end - index - 1;
            end = index;
        }
        if (end != 0 && end > max) max = end;
        return max;
    }
	
	/*
	 * Keep a stack storing index of unmatched parentheses
	 * Scan once, and each time update max when match happens
	 * Complexity: O(n)
	 */
	public int longestValidParentheses2(String s) {
		Stack<Integer> st = new Stack<Integer>();   // only store index of unmatched parentheses
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // match situation
            if (!st.isEmpty() && s.charAt(i) == ')' && s.charAt(st.peek()) == '(') {
                st.pop();
                if (st.isEmpty()) { // all parenthese before is matched
                    max = i + 1;
                } else {
                    max = Math.max(max, i - st.peek());	// the parentheses from index st.peek() + 1 to i are all matched
                }
            } else {    // unmatched situation
                st.push(i);
            }
        }
        return max;
    }
	
	/*
	
dp[i]表示以index i开头的最长valid parentheses长度

先初始化dp[s.length() - 1] = 0
General Term:
dp[i] = 
     if str[i] == ‘)’，则这个substring肯定是invalid的，dp[i] = 0
     if str[i] == ‘(‘，则首先跳过中间一段可能是valid的parentheses，
     找到dp[i + 1]这个长度的中间parentheses后第一个位置，j = i + 1 + dp[i + 1]，
     正好就是str[i]后面越过完整valid sequence的第一个char，如果这个char是’)’，则
     组成一个valid sequence，例如 ( ()() )，所以dp[i] = 2 + dp[i + 1]；
     此时还要检查dp[j + 1]是否也是valid sequence，如果也是，就可以跟之前的
     valid sequence组成更长的一个sequence，例如(()()) ()，所以如果j + 1 < s.lengt()， dp[i] += dp[j + 1]
	*/
	// DP solution
	public int longestValidParentheses_DP(String s) {
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[s.length() - 1] = 0;
        int max = 0;
        
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                dp[i] = 0;
            } else {
                int j = i + 1 + dp[i + 1];
                if (j < s.length() && s.charAt(j) == ')') {
                    dp[i] = 2 + dp[i + 1];
                    if (j + 1 < s.length()) {
                        dp[i] += dp[j + 1];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
	
	
	// naive solution
	public int longestValidParenthesesSol1(String s) {
        if (s.length() <= 1)
            return 0;
        
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // compute max length of valid parenthese of string starting at index i
            if (s.charAt(i) == '(') {
                Stack<Character> st = new Stack<Character>();
                int count = 0;
                for (int j = i; j < s.length(); j++) {
                    count++;
                    char ch = s.charAt(j);
                    if (st.isEmpty()) {
                        st.push(ch);
                    } else if (st.peek() == '(' && ch == ')') {
                        st.pop();
                    } else {
                        st.push(ch);
                    }
                    
                    if (st.isEmpty()) {
                        if (count > max) {
                            max = count;
                        }
                    }
                }
            }
        }
        return max;
    }
	
	
}
