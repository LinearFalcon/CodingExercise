package edu.nyu.liangfang.leetcode;

import java.util.Arrays;

public class scrambleString {
	/*
	 * There are O(n) possible split points. At each point, there are two possibilities: 
	 * with swap and without swap. At each point, we recursively check the two substrings 
	 * until both of them are single character, which takes time O(2^k+2^(n-k)), where k 
	 * and n-k are the lengths of the two substrings. So, this algorithm runs in exponential 
	 * time, O(2^n), and space complexity is also exponential (recursion stack).
	 */
	// faster method - exponential time O(2^n)  
	public boolean isScramble_alittlefast(String s1, String s2) {
    if (s1.length() != s2.length()) {
        return false;
    }
    if (s1.equals(s2)) {
        return true;
    }

    int len = s1.length();    
    int val1 = 0;
    int val2 = 0;
    for (int i = 0; i < len; i++) {
        val1 += s1.charAt(i) - 'a';
        val2 += s2.charAt(i) - 'a';
    }
    if (val1 != val2) {
        return false;
    }

    for (int i = 1; i < len; i++) {
        if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && 
             isScramble(s1.substring(i), s2.substring(i))) || 
             (isScramble(s1.substring(0, i), s2.substring(len - i)) && 
             isScramble(s1.substring(i), s2.substring(0, len - i))))  {
            return true;         
        }
    }
    return false;
	}
	
	// 2nd method - sort first
		public boolean isScramble2(String s1, String s2) {
		    if (s1.length() != s2.length()) {
		        return false;
		    }
		    if (s1.equals(s2)) {
		        return true;
		    }
		    
		    char[] ss1 = s1.toCharArray();
		    char[] ss2 = s2.toCharArray();
		    Arrays.sort(ss1);
		    Arrays.sort(ss2);
		    String sort1 = String.valueOf(ss1);
		    String sort2 = String.valueOf(ss2);
		    if (!sort1.equals(sort2)) {
		        return false;
		    }
		    
		    int len = s1.length();
		    for (int i = 1; i < len; i++) {
		        if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && 
		             isScramble(s1.substring(i), s2.substring(i))) || 
		             (isScramble(s1.substring(0, i), s2.substring(len - i)) && 
		             isScramble(s1.substring(i), s2.substring(0, len - i))))  {
		            return true;         
		        }
		    }
		    return false;
		}
	
	
	// DP solution - O(n^4)
	/*
  Second method: comes up with DP naturally
  f[n][i][j] means isScramble(s1[i: i+n], s2[j: j+n])
  f[n][i][j] = f[k][i][j] && f[n - k][i+k][j+k]
              || f[k][i][j+n-k] && f[n-k][i+k][j]

*/

	public boolean isScramble_DP(String s1, String s2) {
   if( s1.length() != s2.length() ){
       return false;
   }
   
   if( s1.length() == 0 || s1.equals(s2)) {
       return true;
   }
   
   int n = s1.length();
   boolean[][][] rst = new boolean[n][n][n];
   for(int i=0; i< n; i++){
       for(int j=0;j<n; j++){
           rst[0][i][j] = s1.charAt(i) == s2.charAt(j);
       }
   }
   
   for(int len = 2; len <= n; len++){
       for(int i = n - len; i>= 0; i--) {
           for(int j = n - len;  j>=0; j--){
               boolean r = false;
               for(int k = 1; k < len && r == false; k++){
                   r = (rst[k-1][i][j] && rst[len-k-1][i+k][j+k]) || (rst[k-1][i][j+len-k] && rst[len-k-1][i+k][j]);
               }
               rst[len-1][i][j] = r;
           }
       }
   }
   
   return rst[n-1][0][0];
	}
	
	
	
	
	
	public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        
        // each time before recursion call, firstly check
        // if these two strings can be from the same one, TLE without this check!
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);
        String sort1 = String.valueOf(ss1);
        String sort2 = String.valueOf(ss2);	
        if (!sort1.equals(sort2)) {		// this could trim lots of uncessary recursion  equals doesn't mean true!!!!!!
            return false;							// if the characters in two strings are different, they can’t be scramble either.
        }
        
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            
            // check forward order
            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }
            
            // check reverse order
            s21 = s2.substring(s2.length() - i);    // check mirror partition
            s22 = s2.substring(0, s2.length() - i);
            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }
        }
        return false;
    }
	
}
