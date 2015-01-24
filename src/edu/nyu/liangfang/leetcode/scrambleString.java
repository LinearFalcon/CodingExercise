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
	
	// AC method - sort first
	public boolean isScramble(String s1, String s2) {
	    if (s1.length() != s2.length()) {
	        return false;
	    }
	    if (s1.equals(s2)) {				// Do not forget this termination condition !!!
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
	    for (int i = 1; i < len; i++) {									// Not include equals !!!
	    	if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && 
	    	    isScramble(s1.substring(i), s2.substring(i))) || 
		       (isScramble(s1.substring(0, i), s2.substring(len - i)) && 
		        isScramble(s1.substring(i), s2.substring(0, len - i))))  {
	    		return true;         
		    }
		}
		return false;
	}
	
	
	/*
    Second method: comes up with DP naturally
    f[n][i][j] means isScramble(s1[i: i+n], s2[j: j+n]) (include)
    f[n][i][j] = f[k][i][j] && f[n - k][i+k][j+k]
                || f[k][i][j+n-k] && f[n-k][i+k][j]
	
	 */
	// Time: O(n^4)
	public boolean isScramble_DP(String s1, String s2) {
		if( s1.length() != s2.length() ){
			return false;
		}
     
		if(s1.equals(s2)) {
			return true;
		}
     
		int n = s1.length();
		boolean[][][] rst = new boolean[n][n][n];
		for(int i=0; i< n; i++){
			for(int j=0;j<n; j++){
				rst[0][i][j] = s1.charAt(i) == s2.charAt(j);
			}
		}
     
		for(int len = 2; len <= n; len++){	// len starts from 2, since 1 is already computed
			for (int i = 0; i <= n - len; i++) {		// 对于每一个substring of s1 and s2
                for (int j = 0; j <= n - len; j++) {
					// check if rst[len - 1][i][j] is true
					boolean r = false;						
					// if we find any kind of partition is true, then we can assign rst[len-1][i][j] true, so termination condition contains 'r == false'
					for(int k = 1; k < len && r == false; k++){		
						r = (rst[k-1][i][j] && rst[len-k-1][i+k][j+k]) || 
								(rst[k-1][i][j+len-k] && rst[len-k-1][i+k][j]);
					}
					rst[len-1][i][j] = r;
				}
			}
		}
     
		return rst[n-1][0][0];
	}	
}

